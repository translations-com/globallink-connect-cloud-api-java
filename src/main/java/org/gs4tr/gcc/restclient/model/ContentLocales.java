package org.gs4tr.gcc.restclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentLocales {
    @JsonProperty("content_id")
    private String contentId;
    @JsonProperty("target_locale")
    private List<String> targetLocales;

    public ContentLocales(String contentId, List<String> targetLocales) {
	this.contentId = contentId;
	this.targetLocales = targetLocales;
	if (targetLocales == null || targetLocales.size() <= 0) {
	    throw new IllegalArgumentException("At least one target locale is required");
	}
    }
}
