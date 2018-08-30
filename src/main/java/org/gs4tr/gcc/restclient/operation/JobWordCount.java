package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.model.GCTask;
import org.gs4tr.gcc.restclient.model.WordCountSummary;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.JobRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobWordCount extends GCOperation {

    private final JobRequest request;

    public JobWordCount(GCConfig config, JobRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "jobs/wordcount";
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
	return getRequest();
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return JobWordCountResponse.class;
    }

    public JobRequest getRequest() {
	return request;
    }

    public static class JobWordCountResponse extends GCResponse {

	@JsonProperty("response_data")
	private List<WordCountSummary> responseData;

	public List<WordCountSummary> getResponseData() {
	    return responseData;
	}

	public void setResponseData(List<WordCountSummary> responseData) {
	    this.responseData = responseData;
	}

    }

}
