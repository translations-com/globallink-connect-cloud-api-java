package org.gs4tr.gcc.restclient.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GCJob {
    @JsonProperty("state")
    private GCJobState state;
    @JsonProperty("submitter")
    private String submitter;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("translated_date")
    private Date translatedDate;
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("job_id")
    private Long jobId;
    @JsonProperty("submission_name")
    private String submissionName;
    @JsonProperty("source_locale")
    private Locale sourceLocale;
    @JsonProperty("target_locale")
    private Locale targetLocale;
    @JsonProperty("language_jobs")
    private List<GCLanguageJob> languageJobs;
    @JsonProperty("attributes")
    private Map<String, String> attributes;

    public GCJob() {

    }

    public GCJobState getState() {
	return state;
    }

    public void setState(GCJobState state) {
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

    public Date getTranslatedDate() {
	return translatedDate;
    }

    public void setTranslatedDate(Date translatedDate) {
	this.translatedDate = translatedDate;
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

    public Locale getTargetLocale() {
	return targetLocale;
    }

    public void setTargetLocale(Locale targetLocale) {
	this.targetLocale = targetLocale;
    }

    public List<GCLanguageJob> getLanguageJobs() {
	return languageJobs;
    }

    public void setLanguageJobs(List<GCLanguageJob> languageJobs) {
	this.languageJobs = languageJobs;
    }

    public Map<String, String> getAttributes() {
	return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
	this.attributes = attributes;
    }

    public Long getJobId() {
	return jobId;
    }

    public void setJobId(Long jobId) {
	this.jobId = jobId;
    }

}
