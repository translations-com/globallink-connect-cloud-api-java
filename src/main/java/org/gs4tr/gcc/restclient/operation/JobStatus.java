package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.Status;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.JobRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobStatus extends GCOperation {

	private final JobRequest request;

	public JobStatus(GCConfig config, JobRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "job/status";
	private static final String REQUEST_METHOD = "GET";

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
		return StatusResponse.class;
	}

	public JobRequest getRequest() {
		return request;
	}

	public static class StatusResponse extends GCResponse {

		@JsonProperty("response_data")
		private Status responseData;

		public Status getResponseData() {
			return responseData;
		}

		public void setResponseData(Status responseData) {
			this.responseData = responseData;
		}

	}

}
