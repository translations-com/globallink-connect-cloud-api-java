package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileType {
    @JsonProperty("node_type_metadata")
    private NodeTypeMetadata nodeTypeMetadata;
    @JsonProperty("file_type")
    private String fileType;

    public FileType() {

    }

    public NodeTypeMetadata getNodeTypeMetadata() {
	return nodeTypeMetadata;
    }

    public void setNodeTypeMetadata(NodeTypeMetadata nodeTypeMetadata) {
	this.nodeTypeMetadata = nodeTypeMetadata;
    }

    public String getFileType() {
	return fileType;
    }

    public void setFileType(String fileType) {
	this.fileType = fileType;
    }

}
