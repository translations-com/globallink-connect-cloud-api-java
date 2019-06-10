package org.gs4tr.gcc.restclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionWordCountData extends GCBasicModel {
    @JsonProperty("target_locale")
    private Locale targetLocale;

    @JsonProperty("current_state")
    private String currentStatus;
    @JsonProperty("wordcount_summary")
    private List<WordCountSummary> wordcountSummary;

    public Locale getTargetLocale() {
	return targetLocale;
    }

    public void setTargetLocale(Locale targetLocale) {
	this.targetLocale = targetLocale;
    }

    public String getCurrentStatus() {
	return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
	this.currentStatus = currentStatus;
    }

    public List<WordCountSummary> getWordcountSummary() {
	return wordcountSummary;
    }

    public void setWordcountSummary(List<WordCountSummary> wordcountSummary) {
	this.wordcountSummary = wordcountSummary;
    }

}
