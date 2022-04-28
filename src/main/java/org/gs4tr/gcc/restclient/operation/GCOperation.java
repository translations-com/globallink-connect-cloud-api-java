package org.gs4tr.gcc.restclient.operation;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCSimpleResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class GCOperation {

	protected GCConfig config;
	public static final String DEFAULT_API_VERSION = "v3";
	public static final String API_V3_PREFIX = "api";
	public static final String RESTAPI_V3_PREFIX = "rest-api";

	public GCOperation(GCConfig config) {
		this.setConfig(config);
	}

	public String GetWebApiUrl() {
		String url = this.getConfig().getApiUrl();
		if (!url.endsWith("/")) {
			url = url + "/";
		}
		if(StringUtils.IsNullOrWhiteSpace(this.getConfig().getApiKey())) {
			return url + API_V3_PREFIX + "/" + DEFAULT_API_VERSION + "/";
		} else {
			return url + RESTAPI_V3_PREFIX + "/" + DEFAULT_API_VERSION + "/";
		}
	}

	protected abstract String getApiUrl();

	public abstract GCRequest getRequestObject();

	public abstract Class<? extends GCSimpleResponse> getResponseClass();

	public abstract String getRequestMethod();

	public Boolean allowErrorResponse() {
		return false;
	}

	public String getRequestJson() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public URL getRequestUrl() throws MalformedURLException, JsonProcessingException {
		if (getRequestMethod().equalsIgnoreCase("GET")) {
			ObjectMapper mapper = new ObjectMapper();

			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.IsNullOrWhiteSpace(this.config.getConnectorKey()) && !(this instanceof Connectors)) {
				map.put("connector_key", this.config.getConnectorKey());
			}
			if (getRequestObject() != null) {
				map.putAll(mapper.convertValue(getRequestObject(), Map.class));
			}
			StringBuilder query = new StringBuilder();
			boolean first = true;
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				try {
					if (entry.getValue() == null || (entry.getValue() instanceof Long && ((Long) entry.getValue()) == 0)
							|| StringUtils.IsNullOrWhiteSpace(entry.getValue().toString())) {
						continue;
					}
					if (first) {
						first = false;
					} else {
						query.append("&");
					}
					if (entry.getValue() instanceof Collection) {
						if((this instanceof DataStoreGetEntry || this instanceof ConnectorsInfoGetEntry) && !StringUtils.IsNullOrWhiteSpace(this.config.getApiKey())) {
							Collection<Object> col = (Collection<Object>) entry.getValue();
							for(Object c : col) {
								query.append(entry.getKey()).append("=").append(URLEncoder.encode("" + c, "UTF-8")).append("&");
							}
						} else {
							query.append(entry.getKey()).append("=").append(mapper.writeValueAsString(entry.getValue()));
						}
					} else {
						query.append(entry.getKey()).append("=")
								.append(URLEncoder.encode("" + entry.getValue(), "UTF-8"));
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (query.toString().length() > 0) {
				return new URL(GetWebApiUrl() + getApiUrl() + "?" + query.toString());
			} else {
				return new URL(GetWebApiUrl() + getApiUrl());
			}
		}
		return new URL(GetWebApiUrl() + getApiUrl());
	}

	public GCConfig getConfig() {
		return config;
	}

	public void setConfig(GCConfig config) {
		this.config = config;
	}
}
