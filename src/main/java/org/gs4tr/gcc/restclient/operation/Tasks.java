package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.model.GCTask;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskListRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tasks extends GCOperation {

	private final TaskListRequest request;

	public Tasks(GCConfig config, TaskListRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "task/list";
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
		return TasksResponse.class;
	}

	public TaskListRequest getRequest() {
		return request;
	}

	public static class TasksResponse extends GCResponse {

		@JsonProperty("response_data")
		private TasksResponseData responseData;

		public TasksResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(TasksResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class TasksResponseData extends PageableResponseData {

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
