package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeTypeMetadata {

    @JsonProperty("cd_rule_file_path")
    private String cdRuleFilePath;
    @JsonProperty("pd_classifier")
    private PdClassifier pdClassifier;
    @JsonProperty("icon_url")
    private String iconUrl;

    public NodeTypeMetadata() {

    }

    public String getCdRuleFilePath() {
	return cdRuleFilePath;
    }

    public void setCdRuleFilePath(String cdRuleFilePath) {
	this.cdRuleFilePath = cdRuleFilePath;
    }

    public PdClassifier getPdClassifier() {
	return pdClassifier;
    }

    public void setPdClassifier(PdClassifier pdClassifier) {
	this.pdClassifier = pdClassifier;
    }

    public String getIconUrl() {
	return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
	this.iconUrl = iconUrl;
    }

}
