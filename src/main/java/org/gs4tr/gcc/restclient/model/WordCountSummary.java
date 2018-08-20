package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordCountSummary {
    private Long count;
    private String key;
    @JsonProperty("display_name")
    private String displayName;

    public WordCountSummary() {

    }

    public Long getCount() {
	return count;
    }

    public void setCount(Long count) {
	this.count = count;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getDisplayName() {
	return displayName;
    }

    public void setDisplayName(String displayName) {
	this.displayName = displayName;
    }

}
