package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;

public class TasksDownload extends GCOperation {

	private final TaskRequest request;

	public TasksDownload(GCConfig config, TaskRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "task/download";
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

	public TaskRequest getRequest() {
		return request;
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return null;
	}
}
