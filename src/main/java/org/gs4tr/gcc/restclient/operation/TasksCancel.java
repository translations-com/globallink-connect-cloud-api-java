package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;

public class TasksCancel extends GCOperation {

	private final TaskRequest request;

	public TasksCancel(GCConfig config, TaskRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "task/cancel";
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
		return MessageResponse.class;
	}

	@Override
	public Boolean allowErrorResponse() {
		return true;
	}

	public TaskRequest getRequest() {
		return request;
	}

}
