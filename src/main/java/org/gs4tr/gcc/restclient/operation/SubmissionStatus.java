package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.operation.JobStatus.StatusResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;

public class SubmissionStatus extends GCOperation {

	private final SubmissionRequest request;

	public SubmissionStatus(GCConfig config, SubmissionRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "submission/status";
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
		return StatusResponse.class;
	}

	public SubmissionRequest getRequest() {
		return request;
	}
}
