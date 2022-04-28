package org.gs4tr.gcc.restclient.operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectorsInfoGetEntry extends GCOperation {

	private List<String> keys;

	public ConnectorsInfoGetEntry(GCConfig config, String key) {
		super(config);
		this.keys = Arrays.asList(key);
	}

	private static final String REQUEST_URL = "connector/info/key";
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
		return new ConnectorsInfoGetEntryRequest(keys);
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ConnectorsInfoGetEntryResponse.class;
	}

	public static class ConnectorsInfoGetEntryRequest extends GCRequest {

		@JsonProperty("connector_info_keys")
		private List<String> keys;

		public ConnectorsInfoGetEntryRequest(List<String> keys) {
			this.keys = keys;
		}

		public List<String> getKeys() {
			return keys;
		}

		public void setKeys(List<String> keys) {
			this.keys = keys;
		}

	}

	public static class ConnectorsInfoGetEntryResponse extends GCResponse {

		@JsonProperty("response_data")
		private ConnectorsInfoGetEntryKeys connectorInfoEntryKeys;

		public void setResponseData(ConnectorsInfoGetEntryKeys connectorInfoEntryKeys) {
			this.connectorInfoEntryKeys = connectorInfoEntryKeys;
		}

		@Override
		public ConnectorsInfoGetEntryKeys getResponseData() {
			return connectorInfoEntryKeys;
		}

	}

	public static class ConnectorsInfoGetEntryKeys {
		@JsonProperty("connector_info_keys")
		private List<ConnectorsInfoGetEntryKey> connectorsInfo;
		@JsonProperty("invalid_keys")
		private List<String> invalidKeys;

		public ConnectorsInfoGetEntryKeys() {

		}

		public List<ConnectorsInfoGetEntryKey> getConnectorsInfo() {
			return connectorsInfo;
		}

		public void setConnectorsInfo(List<ConnectorsInfoGetEntryKey> connectorsInfo) {
			this.connectorsInfo = connectorsInfo;
		}

		public List<String> getInvalidKeys() {
			return invalidKeys;
		}

		public void setInvalidKeys(List<String> invalidKeys) {
			this.invalidKeys = invalidKeys;
		}

	}

	public static class ConnectorsInfoGetEntryKey extends HashMap<String, Object> {

		private static final long serialVersionUID = -4349815606386726771L;

		public ConnectorsInfoGetEntryKey() {

		}

	}

}
