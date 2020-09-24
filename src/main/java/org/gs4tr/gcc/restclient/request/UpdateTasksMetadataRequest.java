package org.gs4tr.gcc.restclient.request;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateTasksMetadataRequest extends TasksRequest {

	@JsonProperty("task_metadata")
	private Map<String, Object> metadata;

	public UpdateTasksMetadataRequest(List<Long> taskIds, Map<String, Object> metadata) {
		super(taskIds);
		this.metadata = metadata;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}

}
