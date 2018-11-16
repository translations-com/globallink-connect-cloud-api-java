package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;

public class SubmissionCancel extends GCOperation {

    private final SubmissionRequest request;

    public SubmissionCancel(GCConfig config, SubmissionRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "submissions/cancel";
    private static final String REQUEST_METHOD = "POST";

    @Override
    public String getRequestMethod() {
	return REQUEST_METHOD;
    }

    @Override
    protected String getApiUrl() {
	return REQUEST_URL;
    }

    public SubmissionRequest getRequest() {
	return request;
    }

    @Override
    public GCRequest getRequestObject() {
	return this.getRequest();
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return MessageResponse.class;
    }
}