package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FailedTask {
	@JsonProperty("task_id")
	private Long taskId;
	@JsonProperty("message")
	private String message;

	public FailedTask() {

	}

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
