package org.gs4tr.gcc.restclient.model;

public enum JobStatus {

	PreProcess("Pre-process"), Started("Started"), Analyzed("Analyzed"), Approval("Approval"), Translate("Translate"),
	Review("Review"), Completed("Completed"), Delivered("Delivered"), Cancelled("Cancelled");

	private String value;

	JobStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String text() {
		return value;
	}
}
