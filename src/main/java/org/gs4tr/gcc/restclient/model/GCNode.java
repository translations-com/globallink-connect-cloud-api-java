package org.gs4tr.gcc.restclient.model;

import java.util.Map;

import org.gs4tr.gcc.restclient.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCNode {

    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("node_type")
    private String nodeType;
    @JsonProperty("pd_classifier")
    private String pdClassifier;
    @JsonProperty("node_metadata")
    private Map<String, Object> metadata;
    public GCNode(String nodeId, String name, String nodeType) {
	if (StringUtils.isNullOrEmpty(nodeId))
        {
            throw new IllegalArgumentException("FileId is required");
        }
        if (StringUtils.isNullOrEmpty(name))
        {
            throw new IllegalArgumentException("Name is required");
        }
        if (StringUtils.isNullOrEmpty(nodeType))
        {
            throw new IllegalArgumentException("File type is required");
        }
        this.nodeId = nodeId;
        this.name = name;
        this.nodeType = nodeType;
    }
    
    public GCNode(String nodeId, String name, String nodeType, String pdClassifier, Map<String, Object> metadata) throws Exception{
	this(nodeId, name, nodeType);
	this.pdClassifier = pdClassifier;
	this.metadata = metadata;
    }
    
    public String getNodeId() {
        return nodeId;
    }
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNodeType() {
        return nodeType;
    }
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
    public String getPdClassifier() {
        return pdClassifier;
    }
    public void setPdClassifier(String pdClassifier) {
        this.pdClassifier = pdClassifier;
    }
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
    
}
