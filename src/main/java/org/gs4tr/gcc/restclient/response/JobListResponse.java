package org.gs4tr.gcc.restclient.response;

import java.util.List;

import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.GCJob;

public class JobListResponse {

    private int currentPageNumber;
    private int totalRecordsCount;
    private int totalResultPagesCount;
    private List<GCJob> jobsList;

    public JobListResponse(GCResponse response) {
	if (response != null && response.getResponseData() != null && response.getStatus()!=null && !response.getStatus().equals(404)) {
	    this.currentPageNumber = response.getResponseData().getCurrentPageNumber();
	    this.totalRecordsCount = response.getResponseData().getTotalRecordsCount();
	    this.totalResultPagesCount = response.getResponseData().getTotalResultPagesCount();
	    this.jobsList = response.getResponseData().getJobsList();
	}
    }

    public int getCurrentPageNumber() {
	return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
	this.currentPageNumber = currentPageNumber;
    }

    public int getTotalRecordsCount() {
	return totalRecordsCount;
    }

    public void setTotalRecordsCount(int totalRecordsCount) {
	this.totalRecordsCount = totalRecordsCount;
    }

    public int getTotalResultPagesCount() {
	return totalResultPagesCount;
    }

    public void setTotalResultPagesCount(int totalResultPagesCount) {
	this.totalResultPagesCount = totalResultPagesCount;
    }

    public List<GCJob> getJobsList() {
	return jobsList;
    }

    public void setJobsList(List<GCJob> jobsList) {
	this.jobsList = jobsList;
    }

}
