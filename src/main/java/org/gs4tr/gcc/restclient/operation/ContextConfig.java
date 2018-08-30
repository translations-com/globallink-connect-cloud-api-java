package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.GCBasicModel;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContextConfig extends GCOperation {

    public ContextConfig(GCConfig config) {
	super(config);
    }

    private static final String REQUEST_URL = "context/config";
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
	return ContextConfigResponse.class;
    }

    public static class ContextConfigResponse extends GCResponse {

	@JsonProperty("response_data")
	private ContextConfigResponseData contextConfigResponseData;

	public ContextConfigResponseData getResponseData() {
	    return contextConfigResponseData;
	}

	public void setContextConfigResponseData(ContextConfigResponseData contextConfigResponseData) {
	    this.contextConfigResponseData = contextConfigResponseData;
	}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContextConfigResponseData extends GCBasicModel {
	@JsonProperty("xslt_configs")
	private List<String> xsltConfigs;

	public List<String> getXsltConfigs() {
	    return xsltConfigs;
	}

	public void setXsltConfigs(List<String> xsltConfigs) {
	    this.xsltConfigs = xsltConfigs;
	}

    }
}
