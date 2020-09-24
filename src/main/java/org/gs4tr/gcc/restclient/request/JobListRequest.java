package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.model.JobStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobListRequest extends GCMultiConnectorPageableRequest {

    @JsonProperty("state")
    private String[] jobStatuses;
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("submitter")
    private String submitter;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("is_cancelled")
    private Integer isCancelled;
    @JsonProperty("is_error")
    private Integer isError;
    @JsonProperty("is_overdue")
    private Integer isOverdue;
    @JsonProperty("is_redelivery")
    private Integer isRedelivery;
    @JsonProperty("job_id")
    private Long jobId;
    @JsonProperty("submissionName")
    private String submissionName;

    public JobListRequest() {

    }

    public JobListRequest(Long pageNumber, Long pageSize, JobStatus[] jobStatuses, Long submissionId, String submitter,
	    String locale) {
	super(pageNumber, pageSize);
	setJobStatuses(jobStatuses);
	this.setSubmissionId(submissionId);
	this.submitter = submitter;
	this.locale = locale;
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

    public String getSubmitter() {
	return submitter;
    }

    public void setSubmitter(String submitter) {
	this.submitter = submitter;
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(String locale) {
	this.locale = locale;
    }

    public Long getSubmissionId() {
	return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
	this.submissionId = submissionId;
    }

    public Integer getIsCancelled() {
	return isCancelled;
    }

    public void setIsCancelled(Integer isCancelled) {
	this.isCancelled = isCancelled;
    }

    public Integer getIsError() {
	return isError;
    }

    public void setIsError(Integer isError) {
	this.isError = isError;
    }

    public Integer getIsOverdue() {
	return isOverdue;
    }

    public void setIsOverdue(Integer isOverdue) {
	this.isOverdue = isOverdue;
    }

}
