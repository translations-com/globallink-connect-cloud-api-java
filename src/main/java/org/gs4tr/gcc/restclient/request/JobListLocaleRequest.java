package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.model.JobStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobListLocaleRequest extends JobListRequest {

    @JsonProperty("locale")
    private String locale;

    public JobListLocaleRequest() {

    }

    public JobListLocaleRequest(Long pageNumber, Long pageSize, String locale, JobStatus[] jobStatuses, Long jobId,
	    String submitter) {
	super(pageNumber, pageSize, jobStatuses, jobId, submitter);
	this.locale = locale;
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(String locale) {
	this.locale = locale;
    }

}
