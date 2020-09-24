package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.operation.Jobs.JobsResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;

public class SubmissionJobs extends GCOperation {

	private final SubmissionRequest request;

	public SubmissionJobs(GCConfig config, SubmissionRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "submission/jobs";
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
		return request;
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return JobsResponse.class;
	}

}