package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GCTask {
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("job_id")
    private Long jobId;
    @JsonProperty("task_id")
    private Long taskId;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("content_id")
    private String contentId;
    @JsonProperty("submissionName")
    private String submissionName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("node_type")
    private String nodeType;
    @JsonProperty("unique_identifier")
    private String uniqueIdentifier;
    @JsonProperty("status")
    private String status;
    @JsonProperty("target_locale")
    private Locale targetLocale;
    @JsonProperty("last_updated")
    private Date lastUpdated;

    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("is_cancelled")
    private Boolean isCancelled;
    @JsonProperty("is_error")
    private Boolean isError;
    @JsonProperty("confirm_cancel")
    private Boolean isCancelConfirmed;

    public GCTask() {

    }

    public Long getSubmissionId() {
	return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
	this.submissionId = submissionId;
    }

    public Long getTaskId() {
	return taskId;
    }

    public void setTaskId(Long taskId) {
	this.taskId = taskId;
    }

    public String getNodeId() {
	return nodeId;
    }

    public void setNodeId(String nodeId) {
	this.nodeId = nodeId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getNodeType() {
	return nodeType;
    }

    public void setNodeType(String nodeType) {
	this.nodeType = nodeType;
    }

    public String getUniqueIdentifier() {
	return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
	this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Locale getTargetLocale() {
	return targetLocale;
    }

    public void setTargetLocale(Locale targetLocale) {
	this.targetLocale = targetLocale;
    }

    public Date getLastUpdated() {
	return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
	this.lastUpdated = lastUpdated;
    }

    public Long getJobId() {
	return jobId;
    }

    public void setJobId(Long jobId) {
	this.jobId = jobId;
    }

    public String getContentId() {
	return contentId;
    }

    public void setContentId(String contentId) {
	this.contentId = contentId;
    }

    public String getSubmissionName() {
	return submissionName;
    }

    public void setSubmissionName(String submissionName) {
	this.submissionName = submissionName;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
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

    public Boolean getIsCancelConfirmed() {
	return isCancelConfirmed;
    }

    public void setIsCancelConfirmed(Boolean isCancelConfirmed) {
	this.isCancelConfirmed = isCancelConfirmed;
    }

}
