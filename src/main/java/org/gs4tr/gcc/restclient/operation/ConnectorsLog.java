package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.model.LogEntry;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectorsLog extends GCOperation {
	private final ConnectorsLogRequest request;

	public ConnectorsLog(GCConfig config, List<LogEntry> logEntries) {
		super(config);
		this.request = new ConnectorsLogRequest(logEntries);
	}

	private static final String REQUEST_URL = "util/log";
	private static final String REQUEST_METHOD = "POST";

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
		return getRequest();
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return MessageResponse.class;
	}

	public ConnectorsLogRequest getRequest() {
		return request;
	}

	public class ConnectorsLogRequest extends GCRequest {
		@JsonProperty("logs")
		private List<LogEntry> logEntries;

		public ConnectorsLogRequest(List<LogEntry> logEntries) {
			this.logEntries = logEntries;
		}

		public List<LogEntry> getLogEntries() {
			return logEntries;
		}

		public void setLogEntries(List<LogEntry> logEntries) {
			this.logEntries = logEntries;
		}

	}
}
