package org.gs4tr.gcc.restclient.model;

import java.util.Date;
import java.util.Map;

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
    
    @JsonProperty("public_preview_url")
    private String publicPreviewUrl;
    @JsonProperty("context_url")
    private String contextUrl;
    @JsonProperty("submitter")
    private String submitter;
    @JsonProperty("path")
    private String path;
    @JsonProperty("sequence_number")
    private Long sequenceNumber;
    @JsonProperty("node_metadata")
    private Map<String, Object> nodeMetadata;
    

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

    public String getPublicPreviewUrl() {
        return publicPreviewUrl;
    }

    public void setPublicPreviewUrl(String publicPreviewUrl) {
        this.publicPreviewUrl = publicPreviewUrl;
    }

    public String getContextUrl() {
        return contextUrl;
    }

    public void setContextUrl(String contextUrl) {
        this.contextUrl = contextUrl;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Map<String, Object> getNodeMetadata() {
	return nodeMetadata;
    }

    public void setNodeMetadata(Map<String, Object> nodeMetadata) {
	this.nodeMetadata = nodeMetadata;
    }
    
}
