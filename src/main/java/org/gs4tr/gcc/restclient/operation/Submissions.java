package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.model.GCSubmission;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionsListRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Submissions extends GCOperation {

    private final SubmissionsListRequest request;

    public Submissions(GCConfig config, SubmissionsListRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "submissions";
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
	return SubmissionsResponse.class;
    }

    public SubmissionsListRequest getRequest() {
	return request;
    }

    public static class SubmissionsResponse extends GCResponse {

	@JsonProperty("response_data")
	private SubmissionsResponseData responseData;

	public SubmissionsResponseData getResponseData() {
	    return responseData;
	}

	public void setResponseData(SubmissionsResponseData responseData) {
	    this.responseData = responseData;
	}

    }

    public static class SubmissionsResponseData extends PageableResponseData {
	@JsonProperty("submission_list")
	private List<GCSubmission> submissions;

	public List<GCSubmission> getSubmissions() {
	    return submissions;
	}

	public void setSubmissions(List<GCSubmission> submissions) {
	    this.submissions = submissions;
	}

    }
}
