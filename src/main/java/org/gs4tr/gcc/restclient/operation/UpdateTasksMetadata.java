package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.model.FailedTask;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.UpdateTasksMetadataRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateTasksMetadata extends GCOperation {

	private final UpdateTasksMetadataRequest request;

	public UpdateTasksMetadata(GCConfig config, UpdateTasksMetadataRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "task/metadata";
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

	public static class UpdateTasksMetadataResponse extends GCResponse {
		@JsonProperty("response_data")
		private UpdateTasksMetadataResponseData responseData;

		public UpdateTasksMetadataResponse() {

		}

		public UpdateTasksMetadataResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(UpdateTasksMetadataResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class UpdateTasksMetadataResponseData {
		@JsonProperty("failed_task_id")
		private List<FailedTask> failedTasks;

		public UpdateTasksMetadataResponseData() {

		}

		public List<FailedTask> getFailedTasks() {
			return failedTasks;
		}

		public void setFailedTasks(List<FailedTask> failedTasks) {
			this.failedTasks = failedTasks;
		}

	}

}
