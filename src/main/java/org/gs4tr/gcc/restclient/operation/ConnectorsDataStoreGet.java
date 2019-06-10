package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.DataStoreRequest;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectorsDataStoreGet extends GCOperation {
    public ConnectorsDataStoreGet(GCConfig config) {
	super(config);
    }

    private static final String REQUEST_URL = "connectors/key_data_store";
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
	return ConnectorsDataStoreGetResponse.class;
    }

    public static class ConnectorsDataStoreGetResponse extends GCResponse {

	@JsonProperty("response_data")
	private DataStoreRequest dataStore;

	public void setResponseData(DataStoreRequest dataStore) {
	    this.dataStore = dataStore;
	}

	@Override
	public DataStoreRequest getResponseData() {
	    return dataStore;
	}

    }

}
