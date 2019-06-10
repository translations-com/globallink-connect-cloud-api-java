package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCFile extends GCBasicModel {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("connector_instance_id")
    private long connectorInstanceId;
    @JsonProperty("submitter")
    private String submitter;
    @JsonProperty("path")
    private String path;
    @JsonProperty("sequence_number")
    private Long sequenceNumber;
    @JsonProperty("updated_by")
    private String updatedBy;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("status")
    private String status;
    @JsonProperty("is_translatable")
    private Boolean isTranslatable;
    @JsonProperty("node_metadata")
    private String nodeMetadata;
    @JsonProperty("file_type")
    private String fileType;
    @JsonProperty("content_id")
    private String contentId;
    @JsonProperty("unique_identifier")
    private String uniqueIdentifier;
    @JsonProperty("public_preview_url")
    private String publicPreviewUrl;
    @JsonProperty("context_url")
    private String contextUrl;
    @JsonProperty("target_context_url")
    private String targetContextUrl;
    @JsonProperty("pd_classifier")
    private String pdClassifier;
    @JsonProperty("file_path")
    private String filePath;
    @JsonProperty("name")
    private String name;

    public GCFile() {

    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public long getConnectorInstanceId() {
	return connectorInstanceId;
    }

    public void setConnectorInstanceId(long connectorInstanceId) {
	this.connectorInstanceId = connectorInstanceId;
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

    public String getUpdatedBy() {
	return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Boolean getIsTranslatable() {
	return isTranslatable;
    }

    public void setIsTranslatable(Boolean isTranslatable) {
	this.isTranslatable = isTranslatable;
    }

    public String getNodeMetadata() {
	return nodeMetadata;
    }

    public void setNodeMetadata(String nodeMetadata) {
	this.nodeMetadata = nodeMetadata;
    }

    public String getUniqueIdentifier() {
	return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
	this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getContextUrl() {
	return contextUrl;
    }

    public void setContextUrl(String contextUrl) {
	this.contextUrl = contextUrl;
    }

    public String getPdClassifier() {
	return pdClassifier;
    }

    public void setPdClassifier(String pdClassifier) {
	this.pdClassifier = pdClassifier;
    }

    public String getFilePath() {
	return filePath;
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPublicPreviewUrl() {
	return publicPreviewUrl;
    }

    public void setPublicPreviewUrl(String publicPreviewUrl) {
	this.publicPreviewUrl = publicPreviewUrl;
    }

    public String getFileType() {
	return fileType;
    }

    public void setFileType(String fileType) {
	this.fileType = fileType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTargetContextUrl() {
	return targetContextUrl;
    }

    public void setTargetContextUrl(String targetContextUrl) {
	this.targetContextUrl = targetContextUrl;
    }

}
