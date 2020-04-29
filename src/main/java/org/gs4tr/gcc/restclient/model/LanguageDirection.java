package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageDirection {

	@JsonProperty("source_locale")
	private String sourceLocale;
	@JsonProperty("target_locale")
	private String targetLocale;

	public LanguageDirection() {

	}

	public String getSourceLocale() {
		return sourceLocale;
	}

	public void setSourceLocale(String sourceLocale) {
		this.sourceLocale = sourceLocale;
	}

	public String getTargetLocale() {
		return targetLocale;
	}

	public void setTargetLocale(String targetLocale) {
		this.targetLocale = targetLocale;
	}

}
