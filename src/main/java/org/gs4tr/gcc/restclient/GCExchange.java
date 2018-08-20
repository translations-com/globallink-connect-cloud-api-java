package org.gs4tr.gcc.restclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.gs4tr.gcc.restclient.dto.*;
import org.gs4tr.gcc.restclient.model.*;
import org.gs4tr.gcc.restclient.request.*;
import org.gs4tr.gcc.restclient.response.*;
import org.gs4tr.gcc.restclient.util.*;

public class GCExchange {
    private GCConfig config = null;
    private List<FileType> fileTypes = null;

    public GCExchange(GCConfig config) {
	this.init(config);
    }

    private void init(GCConfig conf) {
	if (StringUtils.IsNullOrWhiteSpace(conf.getApiUrl())) {
	    throw new IllegalArgumentException("APIUrl is required");
	}
	if (StringUtils.IsNullOrWhiteSpace(conf.getUserName())) {
	    throw new IllegalArgumentException("Username is required");
	}
	if (StringUtils.IsNullOrWhiteSpace(conf.getPassword())) {
	    throw new IllegalArgumentException("Password is required");
	}
	if (StringUtils.IsNullOrWhiteSpace(conf.getClientSecretKey())) {
	    throw new IllegalArgumentException("client_secret_key is required");
	}

	this.config = conf;
	if (!this.config.getApiUrl().endsWith("/")) {
	    this.config.setApiUrl(this.config.getApiUrl() + "/");
	}

	login();

	try {
	    getFileTypes();
	} catch (Exception e) {
	    throw new IllegalArgumentException("Incorrect client_secret_key", e);
	}

    }

    private void login() {
	GCResponse response = APIUtils.login(this.config);
	if (response != null && response.getResponseData() != null
		&& response.getResponseData().getUserSessionKey() != null) {
	    config.setBearerToken(response.getResponseData().getUserSessionKey());
	} else {
	    throw new IllegalArgumentException("Login failed");
	}
    }

    /// <summary>
    /// Get available File types for connector
    /// </summary>
    /// <returns>List of <see cref="FileType">file types</see></returns>
    public List<FileType> getFileTypes() {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_FILE_TYPES, new GCRequest());
	fileTypes = response.getResponseData().getFileTypes();
	return fileTypes;
    }

    /// <summary>
    /// Get Locales config for connector
    /// </summary>
    /// <returns>List of <see cref="LocaleConfig">configured
    /// locales</see></returns>
    public List<LocaleConfig> getLocaleConfig() {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_LOCALES, new GCRequest());
	return response.getResponseData().getSupportedLocales();
    }

    /// <sumary>
    /// Get a list of the available translation jobs
    /// </sumary>
    /// <param name="request">[Optional] <see cref="JobListRequest"/></param>
    /// <returns>The available translation job(s) wrapped into <see
    /// cref="JobListResponse"/></returns>
    public JobListResponse jobList(JobListRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_JOB_LIST,
		request != null ? request : new GCRequest());
	return new JobListResponse(response);
    }

    /// <summary>
    /// Will list the available locales that have been chosen for this
    /// translation job
    /// </summary>
    /// <param name="request">[Optional] <see
    /// cref="JobListLocaleRequest"/></param>
    /// <returns>The available translation job(s) wrapped into <see
    /// cref="JobListResponse"/></returns>
    public JobListResponse jobListWithLocale(JobListLocaleRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_JOB_LIST_LOCALE,
		request != null ? request : new GCRequest());
	return new JobListResponse(response);
    }

    /// <summary>
    /// Get submission config for connector
    /// </summary>
    /// <returns>List of <see cref="GCAttribute">submission
    /// attributes</see></returns>
    public List<GCAttribute> jobOptions() {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_JOB_OPTIONS, new GCRequest());
	return response.getResponseData().getAttributes();
    }

    /// <sumary>
    /// Confirms delivery of a task after download and internal processing
    /// </sumary>
    /// <param name="request"><see cref="TaskRequest"/></param>
    /// <returns>Is success</returns>
    public Boolean taskConfirmDelivery(TaskRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_CONFIRM_DELIVERY, request);
	return response.getResponseData().getIsSuccess();
    }

    /// <sumary>
    /// Downloads a specific task (i.e. the translation into one of the
    /// languages)
    /// </sumary>
    /// <param name="request"><see cref="TaskRequest"/></param>
    /// <returns>Translated content as InputStream</returns>
    public InputStream taskDownload(TaskRequest request) throws IOException {
	return APIUtils.doDownload(config, APIUtils.DOWNLOAD_TASK, request);
    }

    /// <summary>
    /// Upload files for translation
    /// </summary>
    /// <param name="request"><see cref="UploadFileRequest"/> </param>
    /// <returns>The file id for the file which will be used to add the file to
    /// a translation job</returns>
    public String uploadFile(UploadFileRequest request) throws Exception {
	Boolean typeFound = false;
	for (FileType type : fileTypes) {
	    if (type.getFileType().equals(request.getFileType())) {
		typeFound = true;
	    }
	}

	if (!typeFound) {
	    throw new Exception("Invalid file_type - " + request.getFileType());
	}
	GCResponse response = APIUtils.doRequestWithParameters(config, APIUtils.REQUEST_FILE_UPLOAD,
		request.getParameters());

	return response.getResponseData().getFileId();
    }

    /// <summary>
    /// Upload Preview File
    /// </summary>
    /// <param name="request"><see
    /// cref="UploadFileContextRequest">Request</see></param>
    /// <returns>Static url of uploaded preview</returns>
    public String uploadContext(UploadFileContextRequest request) {
	GCResponse response = APIUtils.doRequestWithParameters(config, APIUtils.REQUEST_FILE_CONTEXT_UPLOAD,
		request.getParameters());
	return response.getResponseData().getStaticUrl();
    }

    /// <summary>
    /// List the file(s) uploaded that have not been assigned to a translation
    /// job
    /// </summary>
    /// <param name="request">[Optional] <see
    /// cref="PageableRequest">Request</see> to specify page size and page
    /// number</param>
    /// <returns>The list of unsubmited <see cref="GCFile">files</see></returns>
    public List<GCFile> getUnsubmittedFiles() {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_UNSUBMITTED, new GCRequest());
	return response.getResponseData().getFilesList();
    }

    /// <summary>
    /// List the file(s) uploaded that have not been assigned to a translation
    /// job
    /// </summary>
    /// <param name="request">[Optional] <see
    /// cref="PageableRequest">Request</see> to specify page size and page
    /// number</param>
    /// <returns>The list of unsubmited <see cref="GCFile">files</see></returns>
    public List<GCFile> getUnsubmittedFiles(PageableRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_UNSUBMITTED,
		request != null ? request : new GCRequest());
	return response.getResponseData().getFilesList();
    }

    /// <sumary>
    /// Submit one or more already uploaded files for transaltion
    /// </sumary>
    /// <param name="request"><see
    /// cref="JobSubmitFilesRequest">Request</see></param>
    /// <returns>The job UID</returns>
    public long submitFiles(JobSubmitFilesRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_JOB_SUBMIT_FILES, request);

	return response.getResponseData().getJobId();
    }

    /// <sumary>
    /// Submit nodes for translation
    /// </sumary>
    /// <param name="request"><see
    /// cref="JobSubmitNodesRequest">Request</see></param>
    /// <returns>The job UID</returns>
    public long submitNodes(JobSubmitNodesRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_JOB_SUBMIT_NODES, request);

	return response.getResponseData().getJobId();
    }

    /// <sumary>
    /// Gets the workcount report for a given jobId
    /// </sumary>
    /// <param name="request"><see
    /// cref="JobSubmitNodesRequest">Request</see></param>
    /// <returns>List of <see cref="Wordcount"/></returns>
    public List<WordCount> getWordCount(WordcountRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_JOB_WORDCOUNT, request);

	return response.getResponseData().getWordcounts();
    }

    /// <sumary>
    /// Lists the current available tasks, their UID, their parent Job UID and
    /// the status
    /// </sumary>
    /// <param name="request">[Optional] <see
    /// cref="TaskListRequest">Request</see></param>
    /// <returns>List of tasks wrapped into <see
    /// cref="TaskListResponse"/></returns>
    public TaskListResponse taskList() {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_LIST, new GCRequest());

	return new TaskListResponse(response);
    }

    /// <sumary>
    /// Lists the current available tasks, their UID, their parent Job UID and
    /// the status
    /// </sumary>
    /// <param name="request">[Optional] <see
    /// cref="TaskListRequest">Request</see></param>
    /// <returns>List of tasks wrapped into <see
    /// cref="TaskListResponse"/></returns>
    public TaskListResponse taskList(TaskListRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_LIST,
		request != null ? request : new GCRequest());

	return new TaskListResponse(response);
    }
}
