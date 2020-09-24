package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotifyRequest extends GCRequest {

	@JsonProperty("job_id")
	private Long jobId;
	@JsonProperty("task_id")
	private Long taskId;
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("message")
	private String message;

	public NotifyRequest(String message) {
		super();
		this.message = message;
	}

	public NotifyRequest(Long jobId, Long taskId, String subject, String message) {
		super();
		this.jobId = jobId;
		this.taskId = taskId;
		this.subject = subject;
		this.message = message;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
