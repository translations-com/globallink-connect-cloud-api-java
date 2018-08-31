package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.model.GCTask;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.JobRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobTasks extends GCOperation {

    private final JobRequest request;

    public JobTasks(GCConfig config, JobRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "jobs/tasks";
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
	return TasksResponse.class;
    }

    public JobRequest getRequest() {
	return request;
    }

    public static class JobTasksResponse extends GCResponse {

	@JsonProperty("response_data")
	private JobTasksResponseData responseData;

	public JobTasksResponseData getResponseData() {
	    return responseData;
	}

	public void setResponseData(JobTasksResponseData responseData) {
	    this.responseData = responseData;
	}

    }

    public static class JobTasksResponseData extends PageableResponseData {

	@JsonProperty("tasks_list")
	private List<GCTask> tasks;

	public List<GCTask> getTasks() {
	    return tasks;
	}

	public void setTasks(List<GCTask> tasks) {
	    this.tasks = tasks;
	}

    }
}
