package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.UploadFileContextRequest;
import org.gs4tr.gcc.restclient.request.UploadFileContextRequest.ContextType;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Context extends GCOperation {

	private final UploadFileContextRequest request;

	public Context(GCConfig config, UploadFileContextRequest request) {
		super(config);
		this.request = request;
	}

	private static final String REQUEST_URL_HTML = "context/upload/html";
	private static final String REQUEST_URL_XSLT = "context/upload/xslt";
	private static final String REQUEST_URL_ZIP = "context/upload/zip";
	private static final String REQUEST_METHOD = "POST";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		if (ContextType.HTML.equals(this.getRequest().getContextType())) {
			return REQUEST_URL_HTML;
		} else if (ContextType.ZIP.equals(this.getRequest().getContextType())) {
			return REQUEST_URL_ZIP;
		} else if (ContextType.XSLT.equals(this.getRequest().getContextType())) {
			return REQUEST_URL_XSLT;
		} else {
			throw new IllegalArgumentException("Value of contextType is unknown");
		}
	}

	@Override
	public GCRequest getRequestObject() {
		return getRequest();
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ContextResponse.class;
	}

	public UploadFileContextRequest getRequest() {
		return request;
	}

	public static class ContextResponse extends GCResponse {
		@JsonProperty("response_data")
		private ContextResponseData responseData;

		public ContextResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(ContextResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class ContextResponseData {

		@JsonProperty("context_url")
		private String staticUrl;

		public String getStaticUrl() {
			return staticUrl;
		}

		public void setStaticUrl(String staticUrl) {
			this.staticUrl = staticUrl;
		}

	}

}
