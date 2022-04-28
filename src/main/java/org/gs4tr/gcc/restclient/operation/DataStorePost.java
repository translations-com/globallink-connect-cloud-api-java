package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

public class DataStorePost extends GCOperation {
	private DataStorePostRequest request;

	public DataStorePost(GCConfig config, String json) {
		super(config);
		this.request = new DataStorePostRequest(json, config);
	}

	private static final String REQUEST_URL = "datastore";
	private static final String REQUEST_METHOD = "POST";

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
	public String getRequestJson() {
		return "{\"datastore\":"+request.getDatastore()+", \"connector_key\":\""+config.getConnectorKey()+"\"}";
	}

	public static class DataStorePostRequest extends GCRequest {
		private String datastore;

		public DataStorePostRequest(String json, GCConfig config) {
			this.datastore = json;
			this.setConnectorKey(config.getConnectorKey());
		}

		public String getDatastore() {
			return datastore;
		}

		public void setDatastore(String datastore) {
			this.datastore = datastore;
		}
		
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return MessageResponse.class;
	}

}
