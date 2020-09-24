package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.UploadContentReferenceRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentReference extends GCOperation {

	private final UploadContentReferenceRequest request;

	public ContentReference(GCConfig config, UploadContentReferenceRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL = "content/upload/reference";
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
		return ContentReferenceResponse.class;
	}

	public UploadContentReferenceRequest getRequest() {
		return request;
	}

	public static class ContentReferenceResponse extends GCResponse {
		@JsonProperty("response_data")
		private ContentReferenceResponseData responseData;

		public ContentReferenceResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(ContentReferenceResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class ContentReferenceResponseData {

		@JsonProperty("reference_id")
		private String referenceId;

		public String getReferenceId() {
			return referenceId;
		}

		public void setReferenceId(String referenceId) {
			this.referenceId = referenceId;
		}

	}
}
