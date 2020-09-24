package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.JobRequest;

public class JobCancel extends GCOperation {

	private final JobRequest request;

	public JobCancel(GCConfig config, JobRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "job/cancel";
	private static final String REQUEST_METHOD = "POST";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		return REQUEST_URL;
	}

	public JobRequest getRequest() {
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