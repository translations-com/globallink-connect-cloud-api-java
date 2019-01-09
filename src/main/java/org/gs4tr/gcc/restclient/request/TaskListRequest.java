package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.model.TaskStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskListRequest extends PageableRequest {

    @JsonProperty("state")
    private String[] statuses;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("submission_id")
    private Long submissionId;
    @JsonProperty("unique_identifiers")
    private String[] uniqueIdentifiers;
    @JsonProperty("content_ids")
    private String[] contentIds;
    @JsonProperty("is_cancelled")
    private Integer isCancelled;
    @JsonProperty("is_error")
    private Integer isError;
    @JsonProperty("confirm_cancel")
    private Integer isCancelConfirmed;

    public TaskListRequest() {

    }

    public TaskListRequest(TaskStatus[] statuses, String locale, Long submissionId, String[] uniqueIdentifiers,
	    String[] contentIds) {
	setTaskStatuses(statuses);
	this.locale = locale;
	this.submissionId = submissionId;
	this.uniqueIdentifiers = uniqueIdentifiers;
	this.contentIds = contentIds;
    }

    @JsonProperty("state")
    public String[] getStatuses() {
	return statuses;
    }

    public void setTaskStatuses(String[] taskStatuses) {
	this.statuses = taskStatuses;
    }

    public void setTaskStatuses(TaskStatus[] taskStatuses) {
	if (taskStatuses != null && taskStatuses.length > 0) {
	    this.statuses = new String[taskStatuses.length];
	    int i = 0;
	    for (TaskStatus taskStatus : taskStatuses) {
		this.statuses[i++] = taskStatus.text();
	    }
	} else {
	    this.statuses = null;
	}
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(String locale) {
	this.locale = locale;
    }

    public Long getSubmissionId() {
	return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
	this.submissionId = submissionId;
    }

    public String[] getUniqueIdentifiers() {
	return uniqueIdentifiers;
    }

    public void setUniqueIdentifiers(String[] uniqueIdentifiers) {
	this.uniqueIdentifiers = uniqueIdentifiers;
    }

    public String[] getContentIds() {
	return contentIds;
    }

    public void setContentIds(String[] contentIds) {
	this.contentIds = contentIds;
    }

    public void setStatuses(String[] statuses) {
	this.statuses = statuses;
    }

    public Integer getIsCancelled() {
	return isCancelled;
    }

    public void setIsCancelled(Integer isCancelled) {
	this.isCancelled = isCancelled;
    }

    public Integer getIsError() {
	return isError;
    }

    public void setIsError(Integer isError) {
	this.isError = isError;
    }

    public Integer getIsCancelConfirmed() {
	return isCancelConfirmed;
    }

    public void setIsCancelConfirmed(Integer isCancelConfirmed) {
	this.isCancelConfirmed = isCancelConfirmed;
    }

}
