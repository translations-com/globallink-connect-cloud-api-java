package org.gs4tr.gcc.restclient.util;

import static org.gs4tr.gcc.restclient.util.HttpUtils.addHeaders;
import static org.gs4tr.gcc.restclient.util.HttpUtils.openConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.GCSimpleResponse;
import org.gs4tr.gcc.restclient.operation.Connectors;
import org.gs4tr.gcc.restclient.operation.GCOperation;
import org.gs4tr.gcc.restclient.operation.Login;
import org.gs4tr.gcc.restclient.request.GCMultiConnectorPageableRequest;
import org.gs4tr.gcc.restclient.request.GCMultiConnectorRequest;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.w3c.dom.DOMException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIUtils {

	public static GCSimpleResponse doRequestWithParameters(GCOperation operation) {

		MultipartUtility multipart = null;
		try {
			multipart = new MultipartUtility(operation.getRequestUrl(), operation.getConfig(),
					operation.getRequestMethod());
			GCRequest request = operation.getRequestObject();
			if (request != null && request.getParameters() != null) {
				Map<String, Object> parameters = request.getParameters();

				Map<String, Object> m2 = new HashMap<String, Object>();
				for (Map.Entry<String, Object> entry : parameters.entrySet()) {
					String key = entry.getKey();
					if ("connector_id".equals(key)) {
						continue;
					}
					if (key.equals("preview_file") || key.equals("file")) {
						m2.put(key, entry.getValue());
					} else {
						if (!key.equals("ignore_file_name")) {
							multipart.addFormField(key, "" + entry.getValue());
						}
					}

				}

				for (Map.Entry<String, Object> entry : m2.entrySet()) {
					if (parameters.containsKey("name")) {
						multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(), "" + parameters.get("name"));
					} else if (parameters.containsKey("ignore_file_name")) {
						multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(),
								"" + parameters.get("ignore_file_name"));
					} else if (parameters.containsKey("html_file_name")) {
						multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(),
								"" + parameters.get("html_file_name"));
					} else {
						multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(), "unknown");
					}
				}
			}

			multipart.addFormField("connector_key", operation.getConfig().getConnectorKey());
			HttpURLConnection connection = multipart.finish();

			String response = null;
			if (connection.getResponseCode() > 299) {
				response = StringUtils.toString(connection.getErrorStream());
				if (connection.getResponseCode() > 499) {
					if (connection.getResponseCode() == 503) {
						throw new IllegalStateException("Service Temporarily Unavailable");
					} else {
						throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode());
					}
				} else {
					throw new IllegalStateException(response);
				}
			} else {
				response = StringUtils.toString(connection.getInputStream());
			}
			ObjectMapper mapper = new ObjectMapper();
			GCSimpleResponse simpleResponseObj = mapper.readValue(response, operation.getResponseClass());

			if (GCRequest.class.isAssignableFrom(operation.getResponseClass())) {
				GCResponse responseObj = (GCResponse) mapper.readValue(response, GCResponse.class);
				if (connection.getResponseCode() == 401) {
					throw new IllegalAccessError("Token expired");
				}
				if (responseObj.getStatus() == null || !responseObj.getStatus().equals(200)) {
					throw new IllegalStateException(responseObj.getMessage());
				}
			}

			return simpleResponseObj;
		} catch (IOException e) {
			throw new IllegalStateException("Error sending request: " + e.getMessage());
		}
	}

	public static InputStream doDownload(GCOperation operation) {
		return sendRequest(operation);
	}

	public static Object doRequest(GCOperation operation) {
		String response = null;

		InputStream inputStream = sendRequest(operation);
		try {
			response = StringUtils.toString(inputStream);
			operation.getConfig().getLogger().info("Response:" + response);
		} catch (IOException e) {
			throw new IllegalStateException("Error reading response. " + e.getMessage(), e);
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			GCSimpleResponse responseObj = mapper.readValue(response, operation.getResponseClass());
			// not checking if responseObj.getStatus() is 200 or not. some
			// operations can return 400 or 404 as result
			return responseObj;
		} catch (IOException e) {
			throw new DOMException(DOMException.INVALID_STATE_ERR, "Error parsing response. " + e.getMessage());
		}
	}

	private static InputStream sendRequest(GCOperation operation) {
		HttpURLConnection connection = null;
		ObjectMapper mapper = new ObjectMapper();
		String connectorKey = operation.getConfig().getConnectorKey();

		try {
			connection = openConnection(operation.getRequestUrl(), operation.getConfig());
			connection.setRequestMethod(operation.getRequestMethod());
			if (!(operation instanceof Connectors) && !(operation instanceof Login)) {
				if (operation.getConfig().getConnectorKey() == null) {
					throw new IllegalStateException(
							"Connector key is required. You can obtain connector key using 'Connectors' operation");
				}
				
                if (operation.getRequestObject() instanceof GCMultiConnectorRequest)
                {
                	GCMultiConnectorRequest r = (GCMultiConnectorRequest)operation.getRequestObject();
                    if (r.getConnectorIds() == null)
                    {
                        r.setConnectorIds(new ArrayList<String>());
                    }
                    if (!r.getConnectorIds().contains(connectorKey))
                    {
                        r.getConnectorIds().add(connectorKey);
                    }
                    connectorKey = mapper.writeValueAsString(r.getConnectorIds());
                    
                }
                if (operation.getRequestObject() instanceof GCMultiConnectorPageableRequest)
                {
                	GCMultiConnectorPageableRequest r = (GCMultiConnectorPageableRequest)operation.getRequestObject();
                	if (r.getConnectorIds() == null)
                    {
                        r.setConnectorIds(new ArrayList<String>());
                    }
                    if (!r.getConnectorIds().contains(connectorKey))
                    {
                        r.getConnectorIds().add(connectorKey);
                    }
                    connectorKey = mapper.writeValueAsString(r.getConnectorIds());
                }
				
				connection.setRequestProperty("connector_key", connectorKey);
			}
			if(!(operation instanceof Login)) {
				if(StringUtils.IsNullOrWhiteSpace(operation.getConfig().getApiKey())) {
					connection.setRequestProperty("Authorization", "Bearer " + operation.getConfig().getBearerToken());
				} else {
					connection.setRequestProperty("api-key", operation.getConfig().getApiKey());
				}
			}
			connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			addHeaders(connection, operation.getConfig().getCustomHeaders());

			if (operation.getRequestMethod().equals("GET")) {
				connection.setDoOutput(false);
				operation.getConfig().getLogger().info("Request url:" + operation.getRequestUrl());
			} else {
				connection.setDoOutput(true);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), Charset.forName("UTF-8"));
				String json = operation.getRequestJson();
				if (operation.getRequestObject() != null) {
					if (operation.getRequestObject() instanceof GCRequest && !(operation instanceof Login)) {
						GCRequest r = (GCRequest) operation.getRequestObject();
						r.setConnectorKey(connectorKey);
						json = mapper.writeValueAsString(r);
					} else {
						json = mapper.writeValueAsString(operation.getRequestObject());
					}
				}
				operation.getConfig().getLogger().info("Request url:" + operation.getRequestUrl() + ". Json:" + json);
				out.write(json);
				out.close();
			}

			if (connection.getResponseCode() > 299) {
				if (connection.getErrorStream() != null) {
					if (connection.getResponseCode() == 401) {
						throw new IllegalAccessError("Token expired. " + connection.getResponseCode() + ":"
								+ connection.getResponseMessage());
					}
					if (connection.getResponseCode() > 499) {
						if (connection.getResponseCode() == 503) {
							throw new IllegalStateException("Service Temporarily Unavailable");
						} else {
							throw new IllegalStateException(
									"Server returned HTTP code " + connection.getResponseCode());
						}
					} else {
						if (operation.allowErrorResponse()) {
							return connection.getErrorStream();
						} else {
							throw new IllegalStateException(
									"Error sending request. " + StringUtils.toString(connection.getErrorStream()));
						}
					}
				}
				throw new IllegalStateException("Error sending request. " + connection.getResponseMessage() + "("
						+ connection.getResponseCode() + ")");
			}

			return connection.getInputStream();
		} catch (IOException e) {
			throw new IllegalStateException("Error sending request. " + e.getMessage(), e);
		}
	}

}
