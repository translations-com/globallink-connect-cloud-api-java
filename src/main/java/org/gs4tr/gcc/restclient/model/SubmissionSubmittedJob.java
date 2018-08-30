package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionSubmittedJob extends GCBasicModel {

    @JsonProperty("job_id")
    private Long jobId;
    @JsonProperty("connector_locale")
    private String connectorLocale;

    public Long getJobId() {
	return jobId;
    }

    public void setJobId(Long jobId) {
	this.jobId = jobId;
    }

    public String getConnectorLocale() {
	return connectorLocale;
    }

    public void setConnectorLocale(String connectorLocale) {
	this.connectorLocale = connectorLocale;
    }

}
