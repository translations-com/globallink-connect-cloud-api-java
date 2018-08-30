package org.gs4tr.gcc.restclient.model;

public enum SubmissionStatus {
    InPreProcess("In Pre-process"), Started("Started"), Analyzed("Analyzed"), AwaitingApproval(
	    "Awaiting Approval"), AwaitingQuoteApproval("Awaiting Quote Approval"), InProgress(
		    "In Progress"), Review("Review"), Completed("Completed"), Delivered("Delivered");

    private String value;

    SubmissionStatus(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

    public String text() {
	return value;
    }
}