package org.gs4tr.gcc.restclient.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class GCRequest {

	@JsonProperty("connector_key")
	private String connectorKey;

	public GCRequest() {
	}

	@JsonIgnore
	public Map<String, Object> getParameters() {
		return new HashMap<String, Object>();
	}

	public String getConnectorKey() {
		return connectorKey;
	}

	public void setConnectorKey(String connectorKey) {
		this.connectorKey = connectorKey;
	}

}
