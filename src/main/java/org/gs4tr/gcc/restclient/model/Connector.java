package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Connector extends GCBasicModel {
    @JsonProperty("connector_key")
    private String connectorKey;
    @JsonProperty("connector_name")
    private String connectorName;

    public String getConnectorKey() {
	return connectorKey;
    }

    public void setConnectorKey(String connectorKey) {
	this.connectorKey = connectorKey;
    }

    public String getConnectorName() {
	return connectorName;
    }

    public void setConnectorName(String connectorName) {
	this.connectorName = connectorName;
    }
}
