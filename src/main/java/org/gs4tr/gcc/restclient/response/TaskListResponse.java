package org.gs4tr.gcc.restclient.response;

import java.util.List;

import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.GCTask;

public class TaskListResponse {

    private int currentPageNumber;
    private int totalRecordsCount;
    private int totalResultPagesCount;
    private List<GCTask> tasksList;

    public TaskListResponse(GCResponse response) {
	if (response != null && response.getResponseData() != null && response.getStatus()!=null && !response.getStatus().equals(404)) {
	    this.currentPageNumber = response.getResponseData().getCurrentPageNumber();
	    this.totalRecordsCount = response.getResponseData().getTotalRecordsCount();
	    this.totalResultPagesCount = response.getResponseData().getTotalResultPagesCount();
	    this.tasksList = response.getResponseData().getTasksList();
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

    public List<GCTask> getTasksList() {
	return tasksList;
    }

    public void setTasksList(List<GCTask> tasksList) {
	this.tasksList = tasksList;
    }

}
