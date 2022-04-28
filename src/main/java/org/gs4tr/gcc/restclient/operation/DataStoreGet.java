package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.util.KeepAsJsonDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class DataStoreGet extends GCOperation {


	public DataStoreGet(GCConfig config) {
		super(config);
	}

	private static final String REQUEST_URL = "datastore";
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
		return DataStoreGetResponse.class;
	}
	
	public static class DataStoreGetResponse extends GCResponse {

		@JsonProperty("response_data")
		private DataStoreGetData dataStore;

		public void setResponseData(DataStoreGetData dataStore) {
			this.dataStore = dataStore;
		}

		@Override
		public DataStoreGetData getResponseData() {
			return dataStore;
		}

	}

	public static class DataStoreGetData {
		@JsonProperty("datastore")
		@JsonDeserialize(using = KeepAsJsonDeserializer.class)
		private String datastore;

		public DataStoreGetData() {

		}

		public String getDatastore() {
			return datastore;
		}

		public void setDatastore(String datastore) {
			this.datastore = datastore;
		}

	}

}
