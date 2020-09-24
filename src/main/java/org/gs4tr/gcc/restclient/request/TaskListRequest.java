package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.model.TaskStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskListRequest extends GCMultiConnectorPageableRequest {

	@JsonProperty("state")
	private String[] statuses;
	@JsonProperty("submission_id")
	private Long submissionId;
	@JsonProperty("unique_identifiers")
	private String[] uniqueIdentifiers;
	@JsonProperty("is_cancelled")
	private Integer isCancelled;
	@JsonProperty("is_error")
	private Integer isError;
	@JsonProperty("confirm_cancel")
	private Integer isCancelConfirmed;
	@JsonProperty("source_locale")
	private String sourceLocale;
	@JsonProperty("target_locales")
	private String[] targetLocales;
	@JsonProperty("submission_name")
	private String submissionName;
	@JsonProperty("path")
	private String path;
	@JsonProperty("submitter")
	private String submitter;
	@JsonProperty("search_string")
	private String searchString;
	@JsonProperty("search_meta_keys")
	private String[] searchMetadataKeys;

	public TaskListRequest() {

	}

	public TaskListRequest(TaskStatus[] statuses, String sourceLocale, Long submissionId, String[] uniqueIdentifiers) {
		setTaskStatuses(statuses);
		this.sourceLocale = sourceLocale;
		this.submissionId = submissionId;
		this.uniqueIdentifiers = uniqueIdentifiers;
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

	public String getSourceLocale() {
		return sourceLocale;
	}

	public void setSourceLocale(String sourceLocale) {
		this.sourceLocale = sourceLocale;
	}

	public String[] getTargetLocales() {
		return targetLocales;
	}

	public void setTargetLocales(String[] targetLocales) {
		this.targetLocales = targetLocales;
	}

	public String getSubmissionName() {
		return submissionName;
	}

	public void setSubmissionName(String submissionName) {
		this.submissionName = submissionName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String[] getSearchMetadataKeys() {
		return searchMetadataKeys;
	}

	public void setSearchMetadataKeys(String[] searchMetadataKeys) {
		this.searchMetadataKeys = searchMetadataKeys;
	}

}
