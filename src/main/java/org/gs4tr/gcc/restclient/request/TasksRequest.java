package org.gs4tr.gcc.restclient.request;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksRequest extends GCRequest {

    @JsonProperty("task_ids")
    private List<Long> taskIds;

    public TasksRequest(Long taskId) {
	this.setTaskIds(Arrays.asList(taskId));
    }

    public TasksRequest(List<Long> taskIds) {
	this.setTaskIds(taskIds);
    }

    public List<Long> getTaskIds() {
	return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
	this.taskIds = taskIds;
    }

}