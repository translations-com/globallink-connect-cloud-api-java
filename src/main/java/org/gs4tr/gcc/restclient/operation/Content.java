package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.PageableResponseData;
import org.gs4tr.gcc.restclient.model.GCFile;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.PageableRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Content extends GCOperation {

	private final PageableRequest request;

	public Content(GCConfig config) {
		super(config);
		request = null;
	}

	public Content(GCConfig config, PageableRequest request) {
		super(config);
		this.request = request;
	}

	public Content(GCConfig config, Long pageNumber, Long pageSize) {
		super(config);
		request = new PageableRequest(pageNumber, pageSize);
	}

	private static final String REQUEST_URL = "content/list";
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
		return getRequest();
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ContentResponse.class;
	}

	public PageableRequest getRequest() {
		return request;
	}

	public static class ContentResponse extends GCResponse {

		@JsonProperty("response_data")
		private ContentResponseData responseData;

		public ContentResponseData getResponseData() {
			return responseData;
		}

		public void setResponseData(ContentResponseData responseData) {
			this.responseData = responseData;
		}

	}

	public static class ContentResponseData extends PageableResponseData {

		@JsonProperty("content_list")
		private List<GCFile> files;

		public List<GCFile> getResponseData() {
			return files;
		}

		public void setResponseData(List<GCFile> files) {
			this.files = files;
		}

	}

}
