package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentHistoryData {

	@JsonProperty("last_updated")
	private Date lastUpdated;
	@JsonProperty("version")
	private String version;
	@JsonProperty("unique_identifier")
	private String uniqueIdentifier;
	@JsonProperty("task_id")
	private long taskId;
	@JsonProperty("change_detection_data")
	private String changeDetectionData;
	@JsonProperty("source_connector_locale")
	private String sourceLocale;
	@JsonProperty("target_connector_locale")
	private String targetLocale;

	public ContentHistoryData() {

	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getChangeDetectionData() {
		return changeDetectionData;
	}

	public void setChangeDetectionData(String changeDetectionData) {
		this.changeDetectionData = changeDetectionData;
	}

	public String getSourceLocale() {
		return sourceLocale;
	}

	public void setSourceLocale(String sourceLocale) {
		this.sourceLocale = sourceLocale;
	}

	public String getTargetLocale() {
		return targetLocale;
	}

	public void setTargetLocale(String targetLocale) {
		this.targetLocale = targetLocale;
	}

}
