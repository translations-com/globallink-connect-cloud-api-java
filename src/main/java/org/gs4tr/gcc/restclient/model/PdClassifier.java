package org.gs4tr.gcc.restclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PdClassifier {

    @JsonProperty("classifier_patterns")
    private List<ClassifierPattern> classifierPatterns;
    @JsonProperty("default_classifier")
    private String defaultClassifier;

    public PdClassifier() {

    }

    public List<ClassifierPattern> getClassifierPatterns() {
	return classifierPatterns;
    }

    public void setClassifierPatterns(List<ClassifierPattern> classifierPatterns) {
	this.classifierPatterns = classifierPatterns;
    }

    public String getDefaultClassifier() {
	return defaultClassifier;
    }

    public void setDefaultClassifier(String defaultClassifier) {
	this.defaultClassifier = defaultClassifier;
    }

}
