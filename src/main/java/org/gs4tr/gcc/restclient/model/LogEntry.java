package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogEntry extends GCBasicModel {
	@JsonProperty("guid")
	private String guid;
	@JsonProperty("method")
	private String method;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("class")
	private String className;
	@JsonProperty("data")
	private String data;
	@JsonProperty("level")
	private String level;
	@JsonProperty("timestamp")
	private Date timestamp;
	@JsonProperty("message")
	private String message;
	@JsonProperty("stacktrace")
	private String stacktrace;
	@JsonProperty("jobid")
	private String jobId;
	@JsonProperty("submission_id")
	private String submissionId;
	@JsonProperty("errordetails")
	private String errorDetails;

	public LogEntry(String level, Date timestamp, String message, String origin) {
		if (!"info".equalsIgnoreCase(level) && !"debug".equalsIgnoreCase(level) && !"warn".equalsIgnoreCase(level)
				&& !"error".equalsIgnoreCase(level)) {
			throw new RuntimeException("Level must be one of [debug, info, warn, error]");
		}
		this.level = level.toLowerCase();
		this.timestamp = timestamp;
		this.message = message;
		this.origin = origin;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

}
