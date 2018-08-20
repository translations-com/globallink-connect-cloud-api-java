package org.gs4tr.gcc.restclient.model;

public enum JobStatus {

    InPreProcess("In Pre-process"), Started("Started"), Analyzed("Analyzed"), Approval("Approval"), InProgress(
	    "In Progress"), Review("Review"), Completed("Completed"), Delivered("Delivered");

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
