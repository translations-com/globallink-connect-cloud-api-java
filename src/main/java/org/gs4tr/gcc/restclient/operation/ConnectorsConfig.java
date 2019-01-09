package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.GCAttribute;
import org.gs4tr.gcc.restclient.model.LocaleConfig;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectorsConfig extends GCOperation {

    public ConnectorsConfig(GCConfig config) {
	super(config);
    }

    private static final String REQUEST_URL = "connectors/config";
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
	return ConnectorsConfigResponse.class;
    }

    public static class ConnectorsConfigResponse extends GCResponse {

	@JsonProperty("response_data")
	private ConnectorsConfigResponseData connectorsConfigResponseData;

	public ConnectorsConfigResponseData getResponseData() {
	    return connectorsConfigResponseData;
	}

	public void setResponseData(ConnectorsConfigResponseData connectorsConfigResponseData) {
	    this.connectorsConfigResponseData = connectorsConfigResponseData;
	}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConnectorsConfigResponseData {
	@JsonProperty("supported_locales")
	private List<LocaleConfig> supportedLocales;
	@JsonProperty("file_types")
	private List<String> fileTypes;
	@JsonProperty("submission_options")
	private ConnectorsConfigSubmissionOptions submissionOptions;

	public List<LocaleConfig> getSupportedLocales() {
	    return supportedLocales;
	}

	public void setSupportedLocales(List<LocaleConfig> supportedLocales) {
	    this.supportedLocales = supportedLocales;
	}

	public List<String> getFileTypes() {
	    return fileTypes;
	}

	public void setFileTypes(List<String> fileTypes) {
	    this.fileTypes = fileTypes;
	}

	public ConnectorsConfigSubmissionOptions getSubmissionOptions() {
	    return submissionOptions;
	}

	public void setSubmissionOptions(ConnectorsConfigSubmissionOptions submissionOptions) {
	    this.submissionOptions = submissionOptions;
	}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConnectorsConfigSubmissionOptions {
	@JsonProperty("attributes")
	private List<GCAttribute> attributes;

	public List<GCAttribute> getAttributes() {
	    return attributes;
	}

	public void setAttributes(List<GCAttribute> attributes) {
	    this.attributes = attributes;
	}

    }
}