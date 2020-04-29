package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.PdPhase;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksPdPhase extends GCOperation {

	private final TaskRequest request;

	public TasksPdPhase(GCConfig config, TaskRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "tasks/pdphase";
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
		return PdPhaseResponse.class;
	}

	@Override
	public Boolean allowErrorResponse() {
		return false;
	}

	public TaskRequest getRequest() {
		return request;
	}

	public static class PdPhaseResponse extends GCResponse {

		@JsonProperty("response_data")
		private PdPhase responseData;

		public PdPhase getResponseData() {
			return responseData;
		}

		public void setResponseData(PdPhase responseData) {
			this.responseData = responseData;
		}

	}
}
