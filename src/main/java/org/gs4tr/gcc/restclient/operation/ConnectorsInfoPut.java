package org.gs4tr.gcc.restclient.operation;

import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConnectorsInfoPut extends GCOperation {

	private ConnectorsInfoPutRequest request;

	public ConnectorsInfoPut(GCConfig config, String key, Object value) {
		super(config);
		this.request = new ConnectorsInfoPutRequest(key, value);
	}

	private static final String REQUEST_URL = "connector/info/key";
	private static final String REQUEST_METHOD = "PUT";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		return REQUEST_URL;
	}

	@Override
	public GCRequest getRequestObject() {
		return request;
	}

	public static class ConnectorsInfoPutRequest extends GCRequest {
		@JsonProperty("key_details")
		private ConnectorsInfoPutItem item;

		public ConnectorsInfoPutRequest(String key, Object value) {
			this.item = new ConnectorsInfoPutItem(key, value);
		}

		@Override
		public Map<String, Object> getParameters() {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.putAll(super.getParameters());
			ObjectMapper mapper = new ObjectMapper();
			try {
				parameters.put("key_details", mapper.writeValueAsString(item));
			} catch(Exception e) {
				throw new IllegalStateException("Error generating json from "+item, e);
			}
			return parameters;
		}
		
	}
	
	public static class ConnectorsInfoPutItem {
		private String key;
		private Object value;

		public ConnectorsInfoPutItem(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		
		
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return MessageResponse.class;
	}

}
