package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskRequest extends GCRequest {

    @JsonProperty("task_id")
    private Long taskId;

    public TaskRequest(Long taskId) {
	this.taskId = taskId;
    }

    public Long getTaskId() {
	return taskId;
    }

    public void setTaskId(Long taskId) {
	this.taskId = taskId;
    }

}
