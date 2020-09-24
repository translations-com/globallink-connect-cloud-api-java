package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.model.GCJob;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.JobListRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Jobs extends GCOperation {

	private final JobListRequest request;

	public Jobs(GCConfig config, JobListRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "job/list";
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
		return JobsResponse.class;
	}

	public JobListRequest getRequest() {
		return request;
	}

	public static class JobsResponse extends GCResponse {

		@JsonProperty("response_data")
		private JobsResponseData responseData;

		public JobsResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(JobsResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class JobsResponseData extends PageableResponseData {

		@JsonProperty("jobs_list")
		private List<GCJob> jobs;

		public List<GCJob> getJobs() {
			return jobs;
		}

		public void setJobs(List<GCJob> jobs) {
			this.jobs = jobs;
		}

	}
}
