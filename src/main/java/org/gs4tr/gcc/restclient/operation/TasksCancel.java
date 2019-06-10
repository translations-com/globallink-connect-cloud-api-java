package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksCancel extends GCOperation {

    private final TaskRequest request;
    
    public TasksCancel(GCConfig config, TaskRequest request) {
	super(config);
	this.request = new TaskRequest(request.getTaskId());
    }

    private static final String REQUEST_URL = "tasks/cancel";
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
	return MessageResponse.class;
    }
    
    @Override
    public Boolean allowErrorResponse(){
	return true;
    }

    public TaskRequest getRequest() {
	return request;
    }

}
