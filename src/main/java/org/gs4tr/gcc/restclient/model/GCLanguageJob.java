package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCLanguageJob {

    @JsonProperty("job_id")
    private Long jobId;
    @JsonProperty("state")
    private GCJobState state;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("translated_date")
    private Date translatedDate;
    @JsonProperty("target_locale")
    private Locale targetLocale;

    public GCLanguageJob() {

    }

    public GCJobState getState() {
	return state;
    }

    public void setState(GCJobState state) {
	this.state = state;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public Date getTranslatedDate() {
	return translatedDate;
    }

    public void setTranslatedDate(Date translatedDate) {
	this.translatedDate = translatedDate;
    }

    public Locale getTargetLocale() {
	return targetLocale;
    }

    public void setTargetLocale(Locale targetLocale) {
	this.targetLocale = targetLocale;
    }

    public Long getJobId() {
	return jobId;
    }

    public void setJobId(Long jobId) {
	this.jobId = jobId;
    }

}
