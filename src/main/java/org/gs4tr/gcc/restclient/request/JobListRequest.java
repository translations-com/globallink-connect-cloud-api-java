package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.model.JobStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobListRequest extends PageableRequest {

    @JsonProperty("state")
    private String[] jobStatuses;
    @JsonProperty("job_id")
    private Long jobId;
    @JsonProperty("submitter")
    private String submitter;

    public JobListRequest() {

    }

    public JobListRequest(Long pageNumber, Long pageSize, JobStatus[] jobStatuses, Long jobId, String submitter) {
	super(pageNumber, pageSize);
	setJobStatuses(jobStatuses);
	this.jobId = jobId;
	this.submitter = submitter;
    }

    public String[] getJobStatuses() {
	return jobStatuses;
    }

    public void setJobStatuses(String[] jobStatuses) {
	this.jobStatuses = jobStatuses;
    }

    public void setJobStatuses(JobStatus[] jobStatuses) {
	if (jobStatuses != null && jobStatuses.length > 0) {
	    this.jobStatuses = new String[jobStatuses.length];
	    int i = 0;
	    for (JobStatus jobStatus : jobStatuses) {
		this.jobStatuses[i++] = jobStatus.text();
	    }
	} else {
	    this.jobStatuses = null;
	}
    }

    public Long getJobId() {
	return jobId;
    }

    public void setJobId(Long jobId) {
	this.jobId = jobId;
    }

    public String getSubmitter() {
	return submitter;
    }

    public void setSubmitter(String submitter) {
	this.submitter = submitter;
    }

}
