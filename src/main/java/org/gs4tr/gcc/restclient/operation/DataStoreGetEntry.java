package org.gs4tr.gcc.restclient.operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataStoreGetEntry extends GCOperation {

	private List<String> keys;

	public DataStoreGetEntry(GCConfig config, String key) {
		super(config);
		this.keys = Arrays.asList(key);
	}

	private static final String REQUEST_URL = "datastore/key";
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
		return new DataStoreGetEntryRequest(keys);
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return DataStoreGetEntryResponse.class;
	}

	public static class DataStoreGetEntryRequest extends GCRequest {

		@JsonProperty("datastore_keys")
		private List<String> keys;

		public DataStoreGetEntryRequest(List<String> keys) {
			this.keys = keys;
		}

		public List<String> getKeys() {
			return keys;
		}

		public void setKeys(List<String> keys) {
			this.keys = keys;
		}

	}

	public static class DataStoreGetEntryResponse extends GCResponse {

		@JsonProperty("response_data")
		private DataStoreGetEntryKeys dataStore;

		public void setResponseData(DataStoreGetEntryKeys dataStore) {
			this.dataStore = dataStore;
		}

		@Override
		public DataStoreGetEntryKeys getResponseData() {
			return dataStore;
		}

	}

	public static class DataStoreGetEntryKeys {
		@JsonProperty("datastore_keys")
		private List<DataStoreGetEntryKey> datastore;
		@JsonProperty("invalid_keys")
		private List<String> invalidKeys;

		public DataStoreGetEntryKeys() {

		}

		public List<DataStoreGetEntryKey> getDatastore() {
			return datastore;
		}

		public void setDatastore(List<DataStoreGetEntryKey> datastore) {
			this.datastore = datastore;
		}

		public List<String> getInvalidKeys() {
			return invalidKeys;
		}

		public void setInvalidKeys(List<String> invalidKeys) {
			this.invalidKeys = invalidKeys;
		}

	}

	public static class DataStoreGetEntryKey extends HashMap<String, Object> {

		private static final long serialVersionUID = -4349815606386726771L;

		public DataStoreGetEntryKey() {

		}

	}

}
