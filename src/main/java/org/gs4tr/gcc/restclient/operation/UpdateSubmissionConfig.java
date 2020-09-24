package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.UpdateSubmissionConfigRequest;

public class UpdateSubmissionConfig extends GCOperation {

	private final UpdateSubmissionConfigRequest request;

	public UpdateSubmissionConfig(GCConfig config, UpdateSubmissionConfigRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "submission/config";
	private static final String REQUEST_METHOD = "PUT";

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
		return MessageResponse.class;
	}

	@Override
	public Boolean allowErrorResponse() {
		return true;
	}

}
