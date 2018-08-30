package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.model.SubmissionStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionsListRequest extends PageableRequest {

    @JsonProperty("state")
    private String[] submissionStatuses;
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("submitter")
    private String submitter;

    public SubmissionsListRequest() {

    }

    public SubmissionsListRequest(Long pageNumber, Long pageSize, SubmissionStatus[] submissionStatuses,
	    Long submissionId, String submitter) {
	super(pageNumber, pageSize);
	setSubmissionStatuses(submissionStatuses);
	this.submissionId = submissionId;
	this.submitter = submitter;
    }

    public void setSubmissionStatuses(SubmissionStatus[] submissionStatuses) {
	if (submissionStatuses != null && submissionStatuses.length > 0) {
	    this.submissionStatuses = new String[submissionStatuses.length];
	    int i = 0;
	    for (SubmissionStatus submissionStatus : submissionStatuses) {
		this.submissionStatuses[i++] = submissionStatus.text();
	    }
	} else {
	    this.submissionStatuses = null;
	}
    }

    public String getSubmitter() {
	return submitter;
    }

    public void setSubmitter(String submitter) {
	this.submitter = submitter;
    }

    public String[] getSubmissionStatuses() {
	return submissionStatuses;
    }

    public void setSubmissionStatuses(String[] submissionStatuses) {
	this.submissionStatuses = submissionStatuses;
    }

    public Long getSubmissionId() {
	return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
	this.submissionId = submissionId;
    }

}
