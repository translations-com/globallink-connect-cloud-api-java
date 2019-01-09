package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;
import org.gs4tr.gcc.restclient.request.TasksRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksConfirmCancellation extends GCOperation {

    private final TasksRequest request;
    
    public TasksConfirmCancellation(GCConfig config, TaskRequest request) {
	super(config);
	this.request = new TasksRequest(request.getTaskId());
    }

    public TasksConfirmCancellation(GCConfig config, TasksRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "tasks/confirm_cancel";
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
	return TasksConfirmCancellationResponse.class;
    }

    public TasksRequest getRequest() {
	return request;
    }

    public static class TasksConfirmCancellationResponse extends GCResponse {

	@JsonProperty("response_data")
	private TasksConfirmCancellationResponseData responseData;

	public TasksConfirmCancellationResponseData getResponseData() {
	    return responseData;
	}

	public void setResponseData(TasksConfirmCancellationResponseData responseData) {
	    this.responseData = responseData;
	}

    }

    public static class TasksConfirmCancellationResponseData {
	@JsonProperty("fail_tasks")
	private List<TaskCancelConfirmation> taskCancelConfirmations;

	public List<TaskCancelConfirmation> getTaskCancelConfirmations() {
	    return taskCancelConfirmations;
	}

	public void setTaskCancelConfirmations(List<TaskCancelConfirmation> taskCancelConfirmations) {
	    this.taskCancelConfirmations = taskCancelConfirmations;
	}

    }

    public static class TaskCancelConfirmation {
	@JsonProperty("task_id")
	private Long taskId;
	@JsonProperty("message")
	private String message;

	public Long getTaskId() {
	    return taskId;
	}

	public void setTaskId(Long taskId) {
	    this.taskId = taskId;
	}

	public String getMessage() {
	    return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}

    }

}
