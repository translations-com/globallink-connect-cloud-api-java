package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.ContentHistoryData;
import org.gs4tr.gcc.restclient.request.CheckHistoryRequest;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentHistory extends GCOperation {

	private final CheckHistoryRequest request;

	public ContentHistory(GCConfig config, CheckHistoryRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "content/history";
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
		return request;
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return CheckHistoryResponse.class;
	}

	public static class CheckHistoryResponse extends GCResponse {
		@JsonProperty("response_data")
		private CheckHistoryResponseData responseData;

		public CheckHistoryResponse() {

		}

		public CheckHistoryResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(CheckHistoryResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class CheckHistoryResponseData {
		@JsonProperty("content_history")
		private List<ContentHistoryData> contentHistory;

		public CheckHistoryResponseData() {

		}

		public List<ContentHistoryData> getContentHistory() {
			return contentHistory;
		}

		public void setContentHistory(List<ContentHistoryData> contentHistory) {
			this.contentHistory = contentHistory;
		}

	}
}
