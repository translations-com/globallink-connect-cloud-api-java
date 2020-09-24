package org.gs4tr.gcc.restclient.request;

import java.util.List;
import java.util.Map;

import org.gs4tr.gcc.restclient.model.SubmissionStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionsListRequest extends GCMultiConnectorPageableRequest {

	@JsonProperty("state")
	private String[] submissionStatuses;
	@JsonProperty("submission_id")
	private Long submissionId;
	@JsonProperty("submitter")
	private String submitter;
	@JsonProperty("is_cancelled")
	private Integer isCancelled;
	@JsonProperty("is_error")
	private Integer isError;
	@JsonProperty("is_overdue")
	private Integer isOverdue;
	@JsonProperty("submission_name")
	private String submissionName;
	@JsonProperty("tags")
	private List<String> tags;

	@JsonProperty("attributes")
	public Map<String, Object> attributes;
	@JsonProperty("is_redelivery")
	public Integer isRedelivery;
	@JsonProperty("search_string")
	public String searchString;
	@JsonProperty("search_config_keys")
	public List<String> searchConfigKeys;

	public SubmissionsListRequest() {

	}

	public SubmissionsListRequest(Long pageNumber, Long pageSize, SubmissionStatus[] submissionStatuses,
			Long submissionId, String submitter) {
		super(pageNumber, pageSize);
		setSubmissionStatuses(submissionStatuses);
		this.submissionId = submissionId;
		this.submitter = submitter;
	}

	public void setSubmissionStatuses(SubmissionStatus[] submissionStatuses) {
		if (submissionStatuses != null && submissionStatuses.length > 0) {
			this.submissionStatuses = new String[submissionStatuses.length];
			int i = 0;
			for (SubmissionStatus submissionStatus : submissionStatuses) {
				this.submissionStatuses[i++] = submissionStatus.text();
			}
		} else {
			this.submissionStatuses = null;
		}
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String[] getSubmissionStatuses() {
		return submissionStatuses;
	}

	public void setSubmissionStatuses(String[] submissionStatuses) {
		this.submissionStatuses = submissionStatuses;
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

	public Integer getIsOverdue() {
		return isOverdue;
	}

	public void setIsOverdue(Integer isOverdue) {
		this.isOverdue = isOverdue;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public Integer getIsRedelivery() {
		return isRedelivery;
	}

	public void setIsRedelivery(Integer isRedelivery) {
		this.isRedelivery = isRedelivery;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<String> getSearchConfigKeys() {
		return searchConfigKeys;
	}

	public void setSearchConfigKeys(List<String> searchConfigKeys) {
		this.searchConfigKeys = searchConfigKeys;
	}

}
