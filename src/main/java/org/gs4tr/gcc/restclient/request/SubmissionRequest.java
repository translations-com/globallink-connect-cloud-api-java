package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionRequest extends PageableRequest {
    @JsonProperty("submission_id")
    private final Long submissionId;

    public SubmissionRequest(Long submissionId) {
	this.submissionId = submissionId;
    }

    public Long getSubmissionId() {
	return submissionId;
    }

}
