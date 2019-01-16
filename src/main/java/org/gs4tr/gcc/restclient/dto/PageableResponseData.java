package org.gs4tr.gcc.restclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PageableResponseData {
    @JsonProperty("current_page_number")
    private Long currentPageNumber;
    @JsonProperty("total_records_count")
    private Long totalRecordsCount;
    @JsonProperty("total_result_pages_count")
    private Long totalResultPagesCount;
    
    public Boolean isEmpty(){
	return totalRecordsCount==null || totalRecordsCount<1;
    }

    public Long getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(Long currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public Long getTotalRecordsCount() {
        return totalRecordsCount;
    }

    public void setTotalRecordsCount(Long totalRecordsCount) {
        this.totalRecordsCount = totalRecordsCount;
    }

    public Long getTotalResultPagesCount() {
        return totalResultPagesCount;
    }

    public void setTotalResultPagesCount(Long totalResultPagesCount) {
        this.totalResultPagesCount = totalResultPagesCount;
    }

}
