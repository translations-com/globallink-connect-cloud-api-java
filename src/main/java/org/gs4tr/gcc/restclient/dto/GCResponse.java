package org.gs4tr.gcc.restclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCResponse {

    private Integer status;
    private Integer statusCode;
    private String error;
    private String message;
    @JsonProperty("response_data")
    private ResponseData responseData;

    public GCResponse() {

    }

    public Integer getStatus() {
	return status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public ResponseData getResponseData() {
	return responseData;
    }

    public void setResponseData(ResponseData responseData) {
	this.responseData = responseData;
    }

    public Integer getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
    }

    public String getError() {
	return error;
    }

    public void setError(String error) {
	this.error = error;
    }

}
