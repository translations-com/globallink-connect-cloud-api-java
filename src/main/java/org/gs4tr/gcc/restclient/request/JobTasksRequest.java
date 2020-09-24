package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobTasksRequest extends PageableRequest {

	@JsonProperty("job_id")
	private Long jobId;

	public JobTasksRequest(Long jobId) {
		this.jobId = jobId;
	}

	public JobTasksRequest(Long jobId, Long pageNumber, Long pageSize) {
		super(pageNumber, pageSize);
		this.jobId = jobId;
	}

}
