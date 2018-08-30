package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRequest extends PageableRequest {

    @JsonProperty("job_id")
    private final Long jobId;
    public JobRequest(Long jobId){
	this.jobId = jobId;
    }
    
    public JobRequest(Long jobId, Long pageNumber, Long pageSize){
	super(pageNumber, pageSize);
	this.jobId = jobId;
    }

    public Long getJobId() {
	return jobId;
    }

}
