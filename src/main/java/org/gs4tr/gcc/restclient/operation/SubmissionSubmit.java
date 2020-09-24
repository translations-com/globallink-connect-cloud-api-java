package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.SubmissionSubmittedJob;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionSubmitRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionSubmit extends GCOperation {

	private final SubmissionSubmitRequest request;

	public SubmissionSubmit(GCConfig config, SubmissionSubmitRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "content/submit";
	private static final String REQUEST_METHOD = "POST";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		return REQUEST_URL;
	}

	public SubmissionSubmitRequest getRequest() {
		return request;
	}

	@Override
	public GCRequest getRequestObject() {
		return this.getRequest();
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return SubmissionSubmitResponse.class;
	}

	public static class SubmissionSubmitResponse extends GCResponse {
		@JsonProperty("response_data")
		private SubmissionSubmitResponseData responseData;

		public SubmissionSubmitResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(SubmissionSubmitResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class SubmissionSubmitResponseData {

		@JsonProperty("submission_id")
		private Long submissionId;
		@JsonProperty("jobs")
		private List<SubmissionSubmittedJob> jobs;

		public Long getSubmissionId() {
			return submissionId;
		}

		public void setSubmissionId(Long submissionId) {
			this.submissionId = submissionId;
		}

		public List<SubmissionSubmittedJob> getJobs() {
			return jobs;
		}

		public void setJobs(List<SubmissionSubmittedJob> jobs) {
			this.jobs = jobs;
		}

	}
}