package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionCreateRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionCreate extends GCOperation {

    private final SubmissionCreateRequest request;

    public SubmissionCreate(GCConfig config, SubmissionCreateRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "submissions/create";
    private static final String REQUEST_METHOD = "POST";

    @Override
    public String getRequestMethod() {
	return REQUEST_METHOD;
    }

    @Override
    protected String getApiUrl() {
	return REQUEST_URL;
    }

    public SubmissionCreateRequest getRequest() {
	return request;
    }

    @Override
    public GCRequest getRequestObject() {
	return this.getRequest();
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return SubmissionCreateResponse.class;
    }

    public static class SubmissionCreateResponse extends GCResponse {
	@JsonProperty("response_data")
	private SubmissionCreateResponseData responseData;

	public SubmissionCreateResponseData getResponseData() {
	    return responseData;
	}

	public void setResponseData(SubmissionCreateResponseData responseData) {
	    this.responseData = responseData;
	}

    }

    public static class SubmissionCreateResponseData {

	@JsonProperty("submission_id")
	private Long submissionId;

	public Long getSubmissionId() {
	    return submissionId;
	}

	public void setSubmissionId(Long submissionId) {
	    this.submissionId = submissionId;
	}

    }
}
