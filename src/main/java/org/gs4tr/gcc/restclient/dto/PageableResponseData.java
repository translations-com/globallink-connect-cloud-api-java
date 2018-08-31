package org.gs4tr.gcc.restclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageableResponseData {
    @JsonProperty("current_page_number")
    private Integer currentPageNumber;
    @JsonProperty("total_records_count")
    private Integer totalRecordsCount;
    @JsonProperty("total_result_pages_count")
    private Integer totalResultPagesCount;
    
    public Boolean isEmpty(){
	return totalRecordsCount==null || totalRecordsCount<1;
    }
    
    public Integer getCurrentPageNumber() {
	return currentPageNumber;
    }

    public void setCurrentPageNumber(Integer currentPageNumber) {
	this.currentPageNumber = currentPageNumber;
    }

    public Integer getTotalRecordsCount() {
	return totalRecordsCount;
    }

    public void setTotalRecordsCount(Integer totalRecordsCount) {
	this.totalRecordsCount = totalRecordsCount;
    }

    public Integer getTotalResultPagesCount() {
	return totalResultPagesCount;
    }

    public void setTotalResultPagesCount(Integer totalResultPagesCount) {
	this.totalResultPagesCount = totalResultPagesCount;
    }

}
