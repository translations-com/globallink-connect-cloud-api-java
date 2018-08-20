package org.gs4tr.gcc.restclient.dto;

import java.util.List;

import org.gs4tr.gcc.restclient.model.FileType;
import org.gs4tr.gcc.restclient.model.GCAttribute;
import org.gs4tr.gcc.restclient.model.GCFile;
import org.gs4tr.gcc.restclient.model.GCJob;
import org.gs4tr.gcc.restclient.model.GCTask;
import org.gs4tr.gcc.restclient.model.LocaleConfig;
import org.gs4tr.gcc.restclient.model.WordCount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {

    @JsonProperty("tasks_list")
    private List<GCTask> tasksList;
    @JsonProperty("files_list")
    private List<GCFile> filesList;
    @JsonProperty("jobs_list")
    private List<GCJob> jobsList;
    @JsonProperty("file_types")
    private List<FileType> fileTypes;
    @JsonProperty("supported_locales")
    private List<LocaleConfig> supportedLocales;
    @JsonProperty("wordcount_data")
    private List<WordCount> wordcounts;
    private List<GCAttribute> attributes;

    @JsonProperty("current_page_number")
    private Integer currentPageNumber;
    @JsonProperty("total_records_count")
    private Integer totalRecordsCount;
    @JsonProperty("total_result_pages_count")
    private Integer totalResultPagesCount;
    @JsonProperty("file_id")
    private String fileId;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("job_id")
    private Long jobId;
    private String name;
    @JsonProperty("static_url")
    private String staticUrl;
    @JsonProperty("is_success")
    private Boolean isSuccess;
    @JsonProperty("user_session_key")
    private String userSessionKey;

    public ResponseData() {

    }

    public List<GCTask> getTasksList() {
	return tasksList;
    }

    public void setTasksList(List<GCTask> tasksList) {
	this.tasksList = tasksList;
    }

    public List<GCFile> getFilesList() {
	return filesList;
    }

    public void setFilesList(List<GCFile> filesList) {
	this.filesList = filesList;
    }

    public List<GCJob> getJobsList() {
	return jobsList;
    }

    public void setJobsList(List<GCJob> jobsList) {
	this.jobsList = jobsList;
    }

    public List<FileType> getFileTypes() {
	return fileTypes;
    }

    public void setFileTypes(List<FileType> fileTypes) {
	this.fileTypes = fileTypes;
    }

    public List<LocaleConfig> getSupportedLocales() {
	return supportedLocales;
    }

    public void setSupportedLocales(List<LocaleConfig> supportedLocales) {
	this.supportedLocales = supportedLocales;
    }

    public List<WordCount> getWordcounts() {
	return wordcounts;
    }

    public void setWordcounts(List<WordCount> wordcounts) {
	this.wordcounts = wordcounts;
    }

    public List<GCAttribute> getAttributes() {
	return attributes;
    }

    public void setAttributes(List<GCAttribute> attributes) {
	this.attributes = attributes;
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

    public String getFileId() {
	return fileId;
    }

    public void setFileId(String fileId) {
	this.fileId = fileId;
    }

    public String getNodeId() {
	return nodeId;
    }

    public void setNodeId(String nodeId) {
	this.nodeId = nodeId;
    }

    public Long getJobId() {
	return jobId;
    }

    public void setJobId(Long jobId) {
	this.jobId = jobId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getStaticUrl() {
	return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
	this.staticUrl = staticUrl;
    }

    public Boolean getIsSuccess() {
	return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
	this.isSuccess = isSuccess;
    }

    public String getUserSessionKey() {
	return userSessionKey;
    }

    public void setUserSessionKey(String userSessionKey) {
	this.userSessionKey = userSessionKey;
    }

}
