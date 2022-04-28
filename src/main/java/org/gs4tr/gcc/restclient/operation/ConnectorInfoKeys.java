package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectorInfoKeys extends GCOperation {
	public ConnectorInfoKeys(GCConfig config) {
		super(config);
	}

	private static final String REQUEST_URL = "connector/info/key/list";
	private static final String REQUEST_METHOD = "GET";

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
		return null;
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ConnectorInfoKeysResponse.class;
	}

	public static class ConnectorInfoKeysResponse extends GCResponse {
		@JsonProperty("response_data")
		private ConnectorInfoKeysResponseData responseData;

		public ConnectorInfoKeysResponse() {
		}

		public ConnectorInfoKeysResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(ConnectorInfoKeysResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class ConnectorInfoKeysResponseData {
		@JsonProperty("info_keys")
		private List<String> keys;

		public ConnectorInfoKeysResponseData() {

		}

		public List<String> getKeys() {
			return keys;
		}

		public void setKeys(List<String> keys) {
			this.keys = keys;
		}

	}

}
