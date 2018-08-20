package org.gs4tr.gcc.restclient.model;

public enum TaskStatus {

    Processing("Processing"), Translate("Translate"), Analyzed("Analyzed"), Review("Review"), ReviewCompleted(
	    "Review-Completed"), Completed(
		    "Completed"), Delivered("Delivered"), Rejected("Rejected"), Cancelled("Cancelled");

    TaskStatus(String value) {
	this.value = value;
    }

    private String value;

    public String text() {
	return value;
    }
}
