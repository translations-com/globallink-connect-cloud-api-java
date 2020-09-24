package org.gs4tr.gcc.restclient.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageableRequest extends GCRequest {

	@JsonProperty("page_number")
	private Long pageNumber;
	@JsonProperty("page_size")
	private Long pageSize;

	public PageableRequest() {

	}

	public PageableRequest(Long pageNumber, Long pageSize) {
		this.setPageNumber(pageNumber);
		this.setPageSize(pageSize);
	}

	public Map<String, Object> getParameters() {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.putAll(super.getParameters());
		if (getPageNumber() > 0 && getPageSize() > 0) {
			parameters.put("page_number", getPageNumber());
			parameters.put("page_size", getPageSize());
		}
		return parameters;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}
}
