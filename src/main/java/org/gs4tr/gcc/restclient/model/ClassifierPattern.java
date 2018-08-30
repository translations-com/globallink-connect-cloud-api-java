package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassifierPattern {

    @JsonProperty("classifier_value")
    private String classifierValue;
    @JsonProperty("regex_pattern")
    private String regexPattern;
    @JsonProperty("cd_rule_file_path")
    private String cdRuleFilePath;

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

    public String getCdRuleFilePath() {
	return cdRuleFilePath;
    }

    public void setCdRuleFilePath(String cdRuleFilePath) {
	this.cdRuleFilePath = cdRuleFilePath;
    }

}
