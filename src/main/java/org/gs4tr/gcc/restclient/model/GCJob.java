package org.gs4tr.gcc.restclient.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCJob extends GCBasicModel {
	@JsonProperty("state")
	private Status status;
	@JsonProperty("submitter")
	private String submitter;
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("translated_date")
	private Date translatedDate;
	@JsonProperty("due_date")
	private Date dueDate;
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
	@JsonProperty("is_cancelled")
	private Boolean isCancelled;
	@JsonProperty("is_error")
	private Boolean isError;
	@JsonProperty("is_overdue")
	private Boolean isOverdue;
	@JsonProperty("pd_submission_id")
	private List<String> pdSubmissionIds;

	public GCJob() {

	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public List<String> getPdSubmissionIds() {
		return pdSubmissionIds;
	}

	public void setPdSubmissionIds(List<String> pdSubmissionIds) {
		this.pdSubmissionIds = pdSubmissionIds;
	}

}
