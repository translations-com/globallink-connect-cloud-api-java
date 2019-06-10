package org.gs4tr.gcc.restclient.model;

public enum SubmissionStatus {
    PreProcess("Pre-process"), Started("Started"), Analyzed("Analyzed"), AwaitingApproval(
	    "Awaiting Approval"), AwaitingQuoteApproval("Awaiting Quote Approval"), Review("Review"), 
    	Approval("Approval"), Translate("Translate"), Completed("Completed"), Delivered("Delivered");

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