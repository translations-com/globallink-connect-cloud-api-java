package org.gs4tr.gcc.restclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GCAttribute {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("default_value")
    private String defaultValue;
    @JsonProperty("is_mandatory")
    private Boolean isMandatory;
    @JsonProperty("is_summary_page_enabled")
    private Boolean isSummaryPageEnabled;
    @JsonProperty("is_searchable")
    private Boolean isSearchable;
    private Boolean enabled;
    @JsonProperty("is_multiselect")
    private Boolean isMultiselect;
    private List<String> values;
    private String type;
    private String key;
    private String name;

    public GCAttribute() {

    }

    public Boolean getIsMandatory() {
	return isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory) {
	this.isMandatory = isMandatory;
    }

    public Boolean getIsSummaryPageEnabled() {
	return isSummaryPageEnabled;
    }

    public void setIsSummaryPageEnabled(Boolean isSummaryPageEnabled) {
	this.isSummaryPageEnabled = isSummaryPageEnabled;
    }

    public Boolean getIsSearchable() {
	return isSearchable;
    }

    public void setIsSearchable(Boolean isSearchable) {
	this.isSearchable = isSearchable;
    }

    public Boolean getEnabled() {
	return enabled;
    }

    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }

    public Boolean getIsMultiselect() {
	return isMultiselect;
    }

    public void setIsMultiselect(Boolean isMultiselect) {
	this.isMultiselect = isMultiselect;
    }

    public List<String> getValues() {
	return values;
    }

    public void setValues(List<String> values) {
	this.values = values;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getDefaultValue() {
	return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
	this.defaultValue = defaultValue;
    }

}
