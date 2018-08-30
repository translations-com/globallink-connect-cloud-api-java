package org.gs4tr.gcc.restclient.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCSubmission extends GCBasicModel {

    @JsonProperty("state")
    private State state;
    @JsonProperty("submitter")
    private String submitter;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("submission_name")
    private String submissionName;
    @JsonProperty("source_locale")
    private Locale sourceLocale;
    @JsonProperty("language_jobs")
    private List<GCLanguageJob> languageJobs;

    public GCSubmission() {

    }

    public State getState() {
	return state;
    }

    public void setState(State state) {
	this.state = state;
    }

    public String getSubmitter() {
	return submitter;
    }

    public void setSubmitter(String submitter) {
	this.submitter = submitter;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public Long getSubmissionId() {
	return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
	this.submissionId = submissionId;
    }

    public String getSubmissionName() {
	return submissionName;
    }

    public void setSubmissionName(String submissionName) {
	this.submissionName = submissionName;
    }

    public Locale getSourceLocale() {
	return sourceLocale;
    }

    public void setSourceLocale(Locale sourceLocale) {
	this.sourceLocale = sourceLocale;
    }

    public List<GCLanguageJob> getLanguageJobs() {
	return languageJobs;
    }

    public void setLanguageJobs(List<GCLanguageJob> languageJobs) {
	this.languageJobs = languageJobs;
    }

}
