package org.gs4tr.gcc.restclient.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocaleConfig {

    @JsonProperty("locale_label")
    private String localeLabel;
    @JsonProperty("pd_locale")
    private String pdLocale;
    @JsonProperty("connector_locale")
    private String connectorLocale;
    @JsonProperty("is_source")
    private Boolean isSource;
    @JsonProperty("target_rules")
    private List<Map<String, String>> targetRules;
    @JsonProperty("post_processing")
    private List<Map<String, Object>> postProcessing;

    public LocaleConfig() {

    }

    public String getLocaleLabel() {
	return localeLabel;
    }

    public void setLocaleLabel(String localeLabel) {
	this.localeLabel = localeLabel;
    }

    public String getPdLocale() {
	return pdLocale;
    }

    public void setPdLocale(String pdLocale) {
	this.pdLocale = pdLocale;
    }

    public String getConnectorLocale() {
	return connectorLocale;
    }

    public void setConnectorLocale(String connectorLocale) {
	this.connectorLocale = connectorLocale;
    }

    public Boolean getIsSource() {
	return isSource;
    }

    public void setIsSource(Boolean isSource) {
	this.isSource = isSource;
    }

    public List<Map<String, String>> getTargetRules() {
	return targetRules;
    }

    public void setTargetRules(List<Map<String, String>> targetRules) {
	this.targetRules = targetRules;
    }

    public List<Map<String, Object>> getPostProcessing() {
	return postProcessing;
    }

    public void setPostProcessing(List<Map<String, Object>> postProcessing) {
	this.postProcessing = postProcessing;
    }

}
