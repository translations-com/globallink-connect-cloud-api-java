package org.gs4tr.gcc.restclient.dto;

public abstract class GCResponse extends GCSimpleResponse {

	private Integer status;
	private Integer statusCode;
	private String error;
	private String message;

	public GCResponse() {

	}

	public abstract Object getResponseData();

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
