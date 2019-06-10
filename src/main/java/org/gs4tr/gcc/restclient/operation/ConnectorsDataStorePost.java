package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.DataStoreRequest;
import org.gs4tr.gcc.restclient.request.GCRequest;

public class ConnectorsDataStorePost extends GCOperation {
    private final DataStoreRequest request;

    public ConnectorsDataStorePost(GCConfig config, DataStoreRequest dataStore) {
	super(config);
	this.request = dataStore;
    }
    
    private static final String REQUEST_URL = "connectors/key_data_store";
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
	return getRequest();
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return MessageResponse.class;
    }
    
    public DataStoreRequest getRequest() {
	return request;
    }
}
