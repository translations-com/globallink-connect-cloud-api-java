package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.Connector;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Connectors extends GCOperation {

    public Connectors(GCConfig config) {
	super(config);
    }

    private static final String REQUEST_URL = "connectors";
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
	return ConnectorsResponse.class;
    }

    public static class ConnectorsResponse extends GCResponse {

	@JsonProperty("response_data")
	private List<Connector> connectors;

	public List<Connector> getResponseData() {
	    return connectors;
	}

	public void setResponseData(List<Connector> connectors) {
	    this.connectors = connectors;
	}

    }

}
