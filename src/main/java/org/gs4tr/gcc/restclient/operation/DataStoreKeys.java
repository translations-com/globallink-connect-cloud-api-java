package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataStoreKeys extends GCOperation {
	public DataStoreKeys(GCConfig config) {
		super(config);
	}

	private static final String REQUEST_URL = "datastore/key/list";
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
		return DataStoreKeysResponse.class;
	}

	public static class DataStoreKeysResponse extends GCResponse {
		@JsonProperty("response_data")
		private DataStoreKeysResponseData responseData;

		public DataStoreKeysResponse() {
		}

		public DataStoreKeysResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(DataStoreKeysResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class DataStoreKeysResponseData {
		@JsonProperty("data_store_keys")
		private List<String> keys;

		public DataStoreKeysResponseData() {

		}

		public List<String> getKeys() {
			return keys;
		}

		public void setKeys(List<String> keys) {
			this.keys = keys;
		}

	}

}
