package org.gs4tr.gcc.restclient.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCMultiConnectorRequest extends GCRequest {

	@JsonProperty("connector_key")
	private List<String> connectorIds;

	public List<String> getConnectorIds() {
		return connectorIds;
	}

	public void setConnectorIds(List<String> connectorIds) {
		this.connectorIds = connectorIds;
	}
}
