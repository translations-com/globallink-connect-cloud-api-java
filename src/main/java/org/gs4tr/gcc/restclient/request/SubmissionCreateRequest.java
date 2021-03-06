package org.gs4tr.gcc.restclient.request;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.gs4tr.gcc.restclient.model.GCNode;
import org.gs4tr.gcc.restclient.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionCreateRequest extends GCRequest {
    @JsonProperty("submission_name")
    private String submissionName;
    @JsonProperty("due_date")
    private Date dueDate;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("source_locale")
    private String sourceLocale;
    @JsonProperty("target_locale")
    private List<String> targetLocales;
    @JsonProperty("task_list")
    private List<GCNode> taskList;
    @JsonProperty("reference_file_list")
    private List<String> referenceFileList;
    @JsonProperty("public_preview_url")
    private String publicPreviewUrl;
    @JsonProperty("context_url")
    private String contextUrl;
    @JsonProperty("submitter")
    private String submitter;
    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonProperty("attributes")
    private Map<String, Object> attributes;
    @JsonProperty("config")
    private Map<String, Object> config;

    public SubmissionCreateRequest(String submissionName, Date dueDate, String sourceLocale, List<String> targetLocales,
	    List<GCNode> taskList) {
	if (StringUtils.isNullOrEmpty(submissionName)) {
	    throw new IllegalArgumentException("Job Name is required");
	}
	if (dueDate.compareTo(new Date()) < 0) {
	    throw new IllegalArgumentException("DueDate must be after current date");
	}
	if (StringUtils.isNullOrEmpty(sourceLocale)) {
	    throw new IllegalArgumentException("Source Locale is required");
	}
	if (targetLocales == null || targetLocales.size() <= 0) {
	    throw new IllegalArgumentException("At least one target locale is required");
	}
	if (taskList == null || taskList.size() <= 0) {
	    throw new IllegalArgumentException("At least one Node is required");
	}
	this.submissionName = submissionName;
	this.dueDate = dueDate;
	this.sourceLocale = sourceLocale;
	this.targetLocales = targetLocales;
	this.taskList = taskList;
    }

    public SubmissionCreateRequest(String jobName, Date dueDate, String sourceLocale, List<String> targetLocales,
	    List<GCNode> taskList, String instructions, String submitter, List<String> referenceFileList,
	    String publicPreviewUrl, String contextUrl, String previewUrl, String callbackUrl,
	    Map<String, Object> attributes, Map<String, Object> config) {
	this(jobName, dueDate, sourceLocale, targetLocales, taskList);
	this.instructions = instructions;
	this.submitter = submitter;
	this.attributes = attributes;
	this.config = config;
	this.referenceFileList = referenceFileList;
	this.publicPreviewUrl = publicPreviewUrl;
	this.contextUrl = contextUrl;
	this.callbackUrl = callbackUrl;
    }

    public String getSubmissionName() {
	return submissionName;
    }

    public void setSubmissionName(String submissionName) {
	this.submissionName = submissionName;
    }

    public Date getDueDate() {
	return dueDate;
    }

    public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
    }

    public String getInstructions() {
	return instructions;
    }

    public void setInstructions(String instructions) {
	this.instructions = instructions;
    }

    public String getSourceLocale() {
	return sourceLocale;
    }

    public void setSourceLocale(String sourceLocale) {
	this.sourceLocale = sourceLocale;
    }

    public List<String> getTargetLocales() {
	return targetLocales;
    }

    public void setTargetLocales(List<String> targetLocales) {
	this.targetLocales = targetLocales;
    }

    public List<GCNode> getTaskList() {
	return taskList;
    }

    public void setTaskList(List<GCNode> taskList) {
	this.taskList = taskList;
    }

    public List<String> getReferenceFileList() {
	return referenceFileList;
    }

    public void setReferenceFileList(List<String> referenceFileList) {
	this.referenceFileList = referenceFileList;
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

    public String getCallbackUrl() {
	return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
	this.callbackUrl = callbackUrl;
    }

    public Map<String, Object> getAttributes() {
	return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
	this.attributes = attributes;
    }

    public Map<String, Object> getConfig() {
	return config;
    }

    public void setConfig(Map<String, Object> config) {
	this.config = config;
    }

}
