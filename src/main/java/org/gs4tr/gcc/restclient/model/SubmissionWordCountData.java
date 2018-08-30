package org.gs4tr.gcc.restclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionWordCountData extends GCBasicModel {
    @JsonProperty("target_locale")
    private Locale targetLocale;

    @JsonProperty("current_state")
    private String currentState;
    @JsonProperty("wordcount_summary")
    private List<WordCountSummary> wordcountSummary;

    public Locale getTargetLocale() {
	return targetLocale;
    }

    public void setTargetLocale(Locale targetLocale) {
	this.targetLocale = targetLocale;
    }

    public String getCurrentState() {
	return currentState;
    }

    public void setCurrentState(String currentState) {
	this.currentState = currentState;
    }

    public List<WordCountSummary> getWordcountSummary() {
	return wordcountSummary;
    }

    public void setWordcountSummary(List<WordCountSummary> wordcountSummary) {
	this.wordcountSummary = wordcountSummary;
    }

}
