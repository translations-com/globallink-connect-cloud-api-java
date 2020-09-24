package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.UploadFileRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentData extends GCOperation {

	private final UploadFileRequest request;

	public ContentData(GCConfig config, UploadFileRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "content/upload/file";
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
		return this.getRequest();
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ContentDataResponse.class;
	}

	public UploadFileRequest getRequest() {
		return request;
	}

	public static class ContentDataResponse extends GCResponse {
		@JsonProperty("response_data")
		private ContentDataResponseData responseData;

		public ContentDataResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(ContentDataResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class ContentDataResponseData {

		@JsonProperty("name")
		private String name;
		@JsonProperty("content_id")
		private String contentId;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContentId() {
			return contentId;
		}

		public void setContentId(String contentId) {
			this.contentId = contentId;
		}

	}

}
