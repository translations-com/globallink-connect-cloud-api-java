package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassifierPattern {

    @JsonProperty("classifier_value")
    private String classifierValue;
    @JsonProperty("regex_pattern")
    private String regexPattern;

    public ClassifierPattern() {

    }

    public String getClassifierValue() {
	return classifierValue;
    }

    public void setClassifierValue(String classifierValue) {
	this.classifierValue = classifierValue;
    }

    public String getRegexPattern() {
	return regexPattern;
    }

    public void setRegexPattern(String regexPattern) {
	this.regexPattern = regexPattern;
    }

}
