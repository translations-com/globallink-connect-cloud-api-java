package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataStoreDelete extends GCOperation {

	private final DataStoreDeleteRequest request;

	public DataStoreDelete(GCConfig config, List<String> keys) {
		super(config);
		this.request = new DataStoreDeleteRequest(keys);
	}

	private static final String REQUEST_URL = "datastore/key";
	private static final String REQUEST_METHOD = "DELETE";

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

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return MessageResponse.class;
	}

	public class DataStoreDeleteRequest extends GCRequest {
		@JsonProperty("datastore_keys")
		private List<String> keys;

		public DataStoreDeleteRequest(List<String> keys) {
			this.keys = keys;
		}

		public List<String> getKeys() {
			return keys;
		}

		public void setKeys(List<String> keys) {
			this.keys = keys;
		}

	}
}
