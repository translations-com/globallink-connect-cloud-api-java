package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksConfirm extends GCOperation {

    private final TaskRequest request;

    public TasksConfirm(GCConfig config, TaskRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "tasks/confirm";
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
	return TasksConfirmResponse.class;
    }

    public TaskRequest getRequest() {
	return request;
    }

    public static class TasksConfirmResponse extends GCResponse {

	@JsonProperty("response_data")
	private TaskConfirmResponseData responseData;

	public TaskConfirmResponseData getResponseData() {
	    return responseData;
	}

	public void setResponseData(TaskConfirmResponseData responseData) {
	    this.responseData = responseData;
	}

    }

    public static class TaskConfirmResponseData {
	@JsonProperty("is_success")
	private Boolean isSuccess;

	public Boolean getIsSuccess() {
	    return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
	    this.isSuccess = isSuccess;
	}

    }

}
