package org.gs4tr.gcc.restclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.operation.Connectors;
import org.gs4tr.gcc.restclient.operation.GCOperation;
import org.gs4tr.gcc.restclient.operation.SessionStart;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.w3c.dom.DOMException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIUtils {

    public static final String LOGIN = "start_session";
    public static final String LOGOUT = "end_session";
    public static final String FILE_TYPES = "connector/config/file_types";
    public static final String REQUEST_LOCALES = "connector/config/locales";
    public static final String REQUEST_FILE_TYPES = "connector/config/file_types";
    public static final String REQUEST_JOB_OPTIONS = "connector/config/job_options";
    public static final String REQUEST_FILE_UPLOAD = "file/upload";
    public static final String REQUEST_FILE_CONTEXT_UPLOAD = "file/context/upload";
    public static final String REQUEST_TASK_LIST = "task/list";
    public static final String REQUEST_TASK_CONFIRM_DELIVERY = "task/confirm_delivery";
    public static final String REQUEST_TASK_UNSUBMITTED = "file/unsubmitted";
    public static final String DOWNLOAD_TASK = "task/download";
    public static final String REQUEST_JOB_LIST = "job/list";
    public static final String REQUEST_JOB_LIST_LOCALE = "locale_job/list";
    public static final String REQUEST_JOB_SUBMIT_FILES = "job/submit/files";
    public static final String REQUEST_JOB_SUBMIT_NODES = "job/submit/nodes";
    public static final String REQUEST_JOB_WORDCOUNT = "job/wordcount";

    public static GCResponse doRequestWithParameters(GCOperation operation) {

	MultipartUtility multipart = null;
	try {
	    multipart = new MultipartUtility(operation.getRequestUrl().toString(), operation.getConfig());
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
			if(!key.equals("ignore_file_name")){
			    multipart.addFormField(key, "" + entry.getValue());
			}
		    }

		}

		for (Map.Entry<String, Object> entry : m2.entrySet()) {
		    if (parameters.containsKey("name")) {
			multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(), "" + parameters.get("name"));
		    } else if (parameters.containsKey("ignore_file_name")) {
			multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(), "" + parameters.get("ignore_file_name"));
		    } else {
			multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(), "unknown");
		    }
		}
	    }

	    HttpsURLConnection connection = multipart.finish();

	    String response = null;
	    if (connection.getResponseCode() > 299) {
		response = StringUtils.toString(connection.getErrorStream());
		if (connection.getResponseCode() > 499) {
		    if (connection.getResponseCode() == 503) {
			throw new IllegalStateException("Service Temporarily Unavailable");
		    } else {
			throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode());
		    }
		}
	    } else {
		response = StringUtils.toString(connection.getInputStream());
	    }
	    ObjectMapper mapper = new ObjectMapper();
	    GCResponse responseObj = mapper.readValue(response, operation.getResponseClass());

	    if (responseObj.getStatus() == null || !responseObj.getStatus().equals(200)) {
		throw new IllegalStateException(responseObj.getMessage());
	    }

	    return responseObj;
	} catch (IOException e) {
	    throw new IllegalStateException("Error sending request: " + e.getMessage());
	}
    }

    public static InputStream doDownload(GCOperation operation) {
	ObjectMapper mapper = new ObjectMapper();
	try {
	    URL url = operation.getRequestUrl();
	    HttpURLConnection connection;
	    if (url.toString().startsWith("https")) {
		connection = (HttpsURLConnection) url.openConnection();
	    } else {
		connection = (HttpURLConnection) url.openConnection();
	    }
	    connection.setRequestMethod(operation.getRequestMethod());
	    if(!(operation instanceof Connectors) && !(operation instanceof SessionStart)){
		if(operation.getConfig().getConnectorKey() == null){
		    throw new IllegalStateException("Connector key is required. You can obtain connector key using 'Connectors' operation");
		}
		connection.setRequestProperty("connector_key", operation.getConfig().getConnectorKey());
	    }
	    connection.setRequestProperty("Authorization", "Bearer " + operation.getConfig().getBearerToken());
	    connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	    if (operation.getRequestMethod().equals("GET")) {
		connection.setDoOutput(false);
	    } else {
		connection.setDoOutput(true);
		if (operation.getRequestObject() != null) {
		    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),
			    Charset.forName("UTF-8"));
		    String json = mapper.writeValueAsString(operation.getRequestObject());
		    out.write(json);
		    out.close();
		}
	    }

	    if (connection.getResponseCode() > 299) {
		String response = StringUtils.toString(connection.getErrorStream());
		if (connection.getResponseCode() > 499) {
		    if (connection.getResponseCode() == 503) {
			throw new IllegalStateException("Service Temporarily Unavailable");
		    } else {
			throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode()+". "+response);
		    }
		}
	    }
	    return connection.getInputStream();
	} catch (IOException e) {
	    throw new IllegalStateException("Error sending request. " + e.getMessage(), e);
	}

    }

    public static Object doRequest(GCOperation operation) {
	ObjectMapper mapper = new ObjectMapper();
	String response = null;
	try {
	    URL url = operation.getRequestUrl();
	    HttpURLConnection connection;
	    if (url.toString().startsWith("https")) {
		connection = (HttpsURLConnection) url.openConnection();
	    } else {
		connection = (HttpURLConnection) url.openConnection();
	    }
	    connection.setRequestMethod(operation.getRequestMethod());
	    if(!(operation instanceof Connectors) && !(operation instanceof SessionStart)){
		if(operation.getConfig().getConnectorKey() == null){
		    throw new IllegalStateException("Connector key is required. You can obtain connector key using 'Connectors' operation");
		}
		connection.setRequestProperty("connector_key", operation.getConfig().getConnectorKey());
	    }
	    connection.setRequestProperty("Authorization", "Bearer " + operation.getConfig().getBearerToken());
	    connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	    if (operation.getRequestMethod().equals("GET")) {
		connection.setDoOutput(false);
	    } else {
		connection.setDoOutput(true);
		if (operation.getRequestObject() != null) {
		    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),
			    Charset.forName("UTF-8"));
		    String json = mapper.writeValueAsString(operation.getRequestObject());
		    out.write(json);
		    out.close();
		}
	    }

	    if (connection.getResponseCode() > 299) {
		response = StringUtils.toString(connection.getErrorStream());
		if (connection.getResponseCode() > 499) {
		    if (connection.getResponseCode() == 503) {
			throw new IllegalStateException("Service Temporarily Unavailable");
		    } else {
			throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode());
		    }
		}
	    } else {
		response = StringUtils.toString(connection.getInputStream());
	    }
	} catch (IOException e) {
	    throw new IllegalStateException("Error sending request. " + e.getMessage(), e);
	}
	try {
	    GCResponse responseObj = mapper.readValue(response, operation.getResponseClass());
	    if (responseObj.getStatus() == null || !responseObj.getStatus().equals(200)) {
		if (responseObj.getStatus().equals(404)
			&& responseObj.getResponseData() instanceof PageableResponseData) {

		} else {
		    throw new IllegalStateException(
			    "Error " + responseObj.getStatus() + ":" + responseObj.getMessage());
		}
	    }

	    return responseObj;
	} catch (IOException e) {
	    throw new DOMException(DOMException.INVALID_STATE_ERR, "Error parsing response. " + e.getMessage());
	}
    }
}
