package org.gs4tr.gcc.restclient.operation;

import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

public class DataStorePut extends GCOperation {

	private DataStorePutRequest request;

	public DataStorePut(GCConfig config, String key, Object value) {
		super(config);
		this.request = new DataStorePutRequest(key, value);
	}

	private static final String REQUEST_URL = "datastore/key";
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

	public static class DataStorePutRequest extends GCRequest {
		private String key;
		private Object value;

		public DataStorePutRequest(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public Map<String, Object> getParameters() {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.putAll(super.getParameters());
			parameters.put(key, value);
			return parameters;
		}
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return MessageResponse.class;
	}

}
