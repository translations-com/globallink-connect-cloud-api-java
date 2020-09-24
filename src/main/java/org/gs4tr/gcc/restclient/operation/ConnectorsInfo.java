package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.util.KeepAsJsonDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ConnectorsInfo extends GCOperation {

	public ConnectorsInfo(GCConfig config) {
		super(config);
	}

	private static final String REQUEST_URL = "connector/info";
	private static final String REQUEST_METHOD = "GET";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		return REQUEST_URL;
	}

	@Override
	public GCRequest getRequestObject() {
		return null;
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ConnectorsInfoResponse.class;
	}

	public static class ConnectorsInfoResponse extends GCResponse {

		@JsonProperty("response_data")
		private ConnectorsInfoResponseData responseData;

		public ConnectorsInfoResponse() {

		}

		public ConnectorsInfoResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(ConnectorsInfoResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class ConnectorsInfoResponseData {
		@JsonProperty("connector_info")
		@JsonDeserialize(using = KeepAsJsonDeserializer.class)
		private String connectorInfoJson;

		public ConnectorsInfoResponseData() {

		}

		public String getConnectorInfoJson() {
			return connectorInfoJson;
		}

		public void setConnectorInfoJson(String connectorInfoJson) {
			this.connectorInfoJson = connectorInfoJson;
		}

	}
}
