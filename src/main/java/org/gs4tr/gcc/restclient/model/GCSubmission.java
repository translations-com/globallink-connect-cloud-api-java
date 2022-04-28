package org.gs4tr.gcc.restclient.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCSubmission extends GCBasicModel {

	@JsonProperty("state")
	private Status status;
	@JsonProperty("submitter")
	private String submitter;
	@JsonProperty("creator")
	private String creator;
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
	@JsonProperty("is_redelivery")
	private Boolean isRedelivery;
	@JsonProperty("config")
	private Map<String, Object> config;
	@JsonProperty("attributes")
	private Map<String, Object> attributes;
	@JsonProperty("tags")
	private List<String> tags;
	@JsonProperty("pd_submission_id")
	private Map<String, String> pdSubmissionIds;
	@JsonProperty("connector_key")
	private String connectorKey;

	public GCSubmission() {

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

	public Map<String, Object> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, String> getPdSubmissionIds() {
		return pdSubmissionIds;
	}

	public void setPdSubmissionIds(Map<String, String> pdSubmissionIds) {
		this.pdSubmissionIds = pdSubmissionIds;
	}

	public String getConnectorKey() {
		return connectorKey;
	}

	public void setConnectorKey(String connectorKey) {
		this.connectorKey = connectorKey;
	}

	public Boolean getIsRedelivery() {
		return isRedelivery;
	}

	public void setIsRedelivery(Boolean isRedelivery) {
		this.isRedelivery = isRedelivery;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
