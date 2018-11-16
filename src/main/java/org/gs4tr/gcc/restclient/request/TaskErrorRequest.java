package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskErrorRequest extends TaskRequest {

    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("error_stacktrace")
    private String errorStacktrace;

    public TaskErrorRequest(Long taskId, String errorMessage, String errorStacktrace) {
	super(taskId);
	this.errorMessage = errorMessage;
	this.errorStacktrace = errorStacktrace;
    }

}
