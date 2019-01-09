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
    @JsonProperty("due_date")
    private Date dueDate;
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("submission_name")
    private String submissionName;
    @JsonProperty("source_locale")
    private Locale sourceLocale;
    @JsonProperty("language_jobs")
    private List<GCLanguageJob> languageJobs;
    @JsonProperty("is_cancelled")
    private Boolean isCancelled;
    @JsonProperty("is_error")
    private Boolean isError;
    @JsonProperty("is_overdue")
    private Boolean isOverdue;

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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Boolean getIsError() {
        return isError;
    }

    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    public Boolean getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

}
