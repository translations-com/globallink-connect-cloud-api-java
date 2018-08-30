package org.gs4tr.gcc.restclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.gs4tr.gcc.restclient.model.Connector;
import org.gs4tr.gcc.restclient.model.FileType;
import org.gs4tr.gcc.restclient.model.State;
import org.gs4tr.gcc.restclient.model.SubmissionWordCountData;
import org.gs4tr.gcc.restclient.model.WordCountSummary;
import org.gs4tr.gcc.restclient.operation.Connectors;
import org.gs4tr.gcc.restclient.operation.Connectors.ConnectorsResponse;
import org.gs4tr.gcc.restclient.operation.ConnectorsConfig;
import org.gs4tr.gcc.restclient.operation.ConnectorsConfig.ConnectorsConfigResponse;
import org.gs4tr.gcc.restclient.operation.ConnectorsConfig.ConnectorsConfigResponseData;
import org.gs4tr.gcc.restclient.operation.Content;
import org.gs4tr.gcc.restclient.operation.Content.ContentResponse;
import org.gs4tr.gcc.restclient.operation.Content.ContentResponseData;
import org.gs4tr.gcc.restclient.operation.ContentData;
import org.gs4tr.gcc.restclient.operation.ContentData.ContentDataResponse;
import org.gs4tr.gcc.restclient.operation.ContentReference;
import org.gs4tr.gcc.restclient.operation.ContentReference.ContentReferenceResponse;
import org.gs4tr.gcc.restclient.operation.Context;
import org.gs4tr.gcc.restclient.operation.Context.ContextResponse;
import org.gs4tr.gcc.restclient.operation.ContextConfig;
import org.gs4tr.gcc.restclient.operation.ContextConfig.ContextConfigResponse;
import org.gs4tr.gcc.restclient.operation.JobStatus;
import org.gs4tr.gcc.restclient.operation.JobStatus.StatusResponse;
import org.gs4tr.gcc.restclient.operation.JobTasks;
import org.gs4tr.gcc.restclient.operation.JobTasks.JobTasksResponse;
import org.gs4tr.gcc.restclient.operation.JobTasks.JobTasksResponseData;
import org.gs4tr.gcc.restclient.operation.JobWordCount;
import org.gs4tr.gcc.restclient.operation.JobWordCount.JobWordCountResponse;
import org.gs4tr.gcc.restclient.operation.Jobs;
import org.gs4tr.gcc.restclient.operation.Jobs.JobsResponse;
import org.gs4tr.gcc.restclient.operation.Jobs.JobsResponseData;
import org.gs4tr.gcc.restclient.operation.SessionStart;
import org.gs4tr.gcc.restclient.operation.SessionStart.SessionStartResponse;
import org.gs4tr.gcc.restclient.operation.SessionTerminate;
import org.gs4tr.gcc.restclient.operation.SubmissionCreate;
import org.gs4tr.gcc.restclient.operation.SubmissionCreate.SubmissionCreateResponse;
import org.gs4tr.gcc.restclient.operation.SubmissionJobs;
import org.gs4tr.gcc.restclient.operation.SubmissionStatus;
import org.gs4tr.gcc.restclient.operation.SubmissionSubmit;
import org.gs4tr.gcc.restclient.operation.SubmissionSubmit.SubmissionSubmitResponse;
import org.gs4tr.gcc.restclient.operation.SubmissionSubmit.SubmissionSubmitResponseData;
import org.gs4tr.gcc.restclient.operation.SubmissionTasks;
import org.gs4tr.gcc.restclient.operation.SubmissionWordCount;
import org.gs4tr.gcc.restclient.operation.SubmissionWordCount.SubmissionWordCountResponse;
import org.gs4tr.gcc.restclient.operation.SubmissionWordCount.SubmissionWordCountResponseData;
import org.gs4tr.gcc.restclient.operation.Submissions;
import org.gs4tr.gcc.restclient.operation.Submissions.SubmissionsResponse;
import org.gs4tr.gcc.restclient.operation.Submissions.SubmissionsResponseData;
import org.gs4tr.gcc.restclient.operation.Tasks;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponse;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponseData;
import org.gs4tr.gcc.restclient.operation.TasksConfirm;
import org.gs4tr.gcc.restclient.operation.TasksConfirm.TasksConfirmResponse;
import org.gs4tr.gcc.restclient.operation.TasksDownload;
import org.gs4tr.gcc.restclient.request.JobListRequest;
import org.gs4tr.gcc.restclient.request.JobRequest;
import org.gs4tr.gcc.restclient.request.SubmissionCreateRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;
import org.gs4tr.gcc.restclient.request.SubmissionSubmitRequest;
import org.gs4tr.gcc.restclient.request.SubmissionsListRequest;
import org.gs4tr.gcc.restclient.request.TaskListRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;
import org.gs4tr.gcc.restclient.request.UploadContentReferenceRequest;
import org.gs4tr.gcc.restclient.request.UploadFileContextRequest;
import org.gs4tr.gcc.restclient.request.UploadFileRequest;
import org.gs4tr.gcc.restclient.util.APIUtils;
import org.gs4tr.gcc.restclient.util.StringUtils;
import org.w3c.dom.DOMException;

public class GCExchange {
    private GCConfig config = null;
    private List<FileType> fileTypes = null;

    public GCExchange(GCConfig config) {
	this.init(config);
    }
    
    public GCConfig getConfig() {
	return this.config;
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

	this.config = conf;
	if (!this.config.getApiUrl().endsWith("/")) {
	    this.config.setApiUrl(this.config.getApiUrl() + "/");
	}

	if(StringUtils.IsNullOrWhiteSpace(this.config.getBearerToken())) {
	    login();
	    try {
		    getConnectors();
		} catch (DOMException e) {
		    throw new IllegalArgumentException("Error parsing response", e);
		} catch (Exception e) {
		    throw new IllegalArgumentException("Incorrect client_secret_key", e);
		}
	}

    }

    private void login() {
	SessionStartResponse response = (SessionStartResponse)APIUtils.doRequest(new SessionStart(config));
	String token = response.getResponseData().getUserSessionKey();
	config.setBearerToken(token);
    }
  
    public Boolean logout() {
	APIUtils.doRequest(new SessionTerminate(config));
	return true;
    }
    
    /// <summary>
    /// Get session token created during automated session start
    /// </summary>
    /// <returns>Session token</returns>
    public String getSessionToken() {
	return config.getBearerToken();
    }
    
    /// <summary>
    /// Gets listing of all connectors available to the user
    /// </summary>
    /// <returns>List of <see cref="Connector">connectors</see></returns>
    public List<Connector> getConnectors() {
	ConnectorsResponse response = (ConnectorsResponse)APIUtils.doRequest(new Connectors(config));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Gets connector config for specified connector token, which includes filetypes, locales and submission config options
    /// </summary>
    /// <returns><see cref="ConnectorsConfigResponseData">Connector config</see> including supported locales and file types</returns>
    public ConnectorsConfigResponseData getConnectorsConfig() {
	ConnectorsConfigResponse response = (ConnectorsConfigResponse)APIUtils.doRequest(new ConnectorsConfig(config));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Returns a list of all content objects that have been uploaded for the specified connector that have not yet been submitted
    /// </summary>
    /// <returns>Paged list of <see cref="GCFile">contents</see></returns>
    public ContentResponseData getContentList() {
	ContentResponse response = (ContentResponse)APIUtils.doRequest(new Content(this.config));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Upload content for translation using <see cref="UploadFileRequest">upload request</see> object. The returned content-id can be used to create a submission
    /// </summary>
    /// <returns>Id of uploaded content</returns>
    public String uploadContent(UploadFileRequest request){
	ContentDataResponse response = (ContentDataResponse)APIUtils.doRequestWithParameters(new ContentData(config, request));
	return response.getResponseData().getContentId();
    }
    
    /// <summary>
    /// Upload a reference file which will be associated with the submission and will be available to the translator and reviewer.
    /// </summary>
    /// <returns>Id of uploaded reference</returns>
    public String uploadContentReference(UploadContentReferenceRequest request){
	ContentReferenceResponse response = (ContentReferenceResponse)APIUtils.doRequestWithParameters(new ContentReference(config, request));
	return response.getResponseData().getReferenceId();
    }
    
    /// <summary>
    /// Get a list of all confgured XSLT profiles, for the specified connector
    /// </summary>
    /// <returns>List of XSLT profiles</returns>
    public List<String> getContextConfigs(){
	ContextConfigResponse response = (ContextConfigResponse)APIUtils.doRequest(new ContextConfig(config));
	return response.getResponseData().getXsltConfigs();
    }
    
    /// <summary>
    /// Upload context using <see cref="UploadFileContextRequest">upload context request</see> object. The returned static url can be used when uploading content
    /// </summary>
    /// <returns>Static preview url of uploaded context</returns>
    public String uploadContext(UploadFileContextRequest request){
	ContextResponse response = (ContextResponse)APIUtils.doRequestWithParameters(new Context(config, request));
	return response.getResponseData().getStaticUrl();
    }
    
    /// <summary>
    /// Get list of jobs for the specified connector instance using <see cref="JobListRequest">JobListRequest</see> object
    /// </summary>
    /// <returns>Paged list of <see cref="GCJob">jobs</see></returns>
    public JobsResponseData getJobsList(JobListRequest request) {
	JobsResponse response = (JobsResponse)APIUtils.doRequest(new Jobs(config, request));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Get the status of the Job
    /// </summary>
    /// <returns>Job <see cref="State">state</see></returns>
    public State getJobState(Long jobId) {
	StatusResponse response = (StatusResponse)APIUtils.doRequest(new JobStatus(config, new JobRequest(jobId)));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Gets the tasks list for the specified job
    /// </summary>
    /// <returns>Paged list of job <see cref="GCTask">tasks</see></returns>
    public JobTasksResponseData getJobTasks(Long jobId) {
	JobTasksResponse response = (JobTasksResponse)APIUtils.doRequest(new JobTasks(config, new JobRequest(jobId)));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Get the analyzed wordcount for a job. A xxx response will be returned if the submission is not yet analyzed
    /// </summary>
    /// <returns>List of <see cref="WordCountSummary">wordcount</see></returns>
    public List<WordCountSummary> getJobWordCount(Long jobId) {
	JobWordCountResponse response = (JobWordCountResponse)APIUtils.doRequest(new JobWordCount(config, new JobRequest(jobId)));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Get list of submissions for the specified connector instance
    /// </summary>
    /// <returns>Paged list of <see cref="GCSubmission">submissions</see></returns>
    public SubmissionsResponseData getSubmissionsList() {
	SubmissionsResponse response = (SubmissionsResponse)APIUtils.doRequest(new Submissions(config, null));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Get list of submissions for the specified connector instance using <see cref="SubmissionsListRequest">SubmissionListRequest</see> object
    /// </summary>
    /// <returns>Paged list of <see cref="GCSubmission">submissions</see></returns>
    public SubmissionsResponseData getSubmissionsList(SubmissionsListRequest request) {
	SubmissionsResponse response = (SubmissionsResponse)APIUtils.doRequest(new Submissions(config, request));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Create a submission from node-ids. The list of node-ids is provided by the plugin that is installed in the client system Notes: 1."connector_locale" is case sensitive 2.Only child nodes(is_parent: 0) can be sent for translation
    /// </summary>
    /// <returns>Id of created submission</returns>
    public Long createSubmission(SubmissionCreateRequest request) {
	SubmissionCreateResponse response = (SubmissionCreateResponse)APIUtils.doRequest(new SubmissionCreate(config, request));
	return response.getResponseData().getSubmissionId();
    }
    
    /// <summary>
    /// Gets the jobs list for the specified submission
    /// </summary>
    /// <returns>Paged list of submission <see cref="GCJob">jobs</see></returns>
    public JobsResponseData getSubmissionJobs(Long submissionId) {
	JobsResponse response = (JobsResponse)APIUtils.doRequest(new SubmissionJobs(config, new SubmissionRequest(submissionId)));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Get the status of the submission
    /// </summary>
    /// <returns>Submission <see cref="State">state</see></returns>
    public State getSubmissionState(Long submissionId) {
	StatusResponse response = (StatusResponse)APIUtils.doRequest(new SubmissionStatus(config, new SubmissionRequest(submissionId)));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Submit a list of one or more content objects (content-ids) to one ore more target languages Notes: 1."connector_locale" is case sensitive 2.Only child nodes(is_parent: 0) can be sent for translation
    /// </summary>
    /// <returns><see cref="SubmissionSubmitResponseData">Response</see> object which contains submission id and jobs</returns>
    public SubmissionSubmitResponseData submitSubmission(SubmissionSubmitRequest request) {
	SubmissionSubmitResponse response = (SubmissionSubmitResponse)APIUtils.doRequest(new SubmissionSubmit(config, request));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Gets the tasks list for the specified submission
    /// </summary>
    /// <returns>Paged list of submission <see cref="GCTask">tasks</see></returns>
    public TasksResponseData getSubmissionTasks(Long submissionId) {
	TasksResponse response = (TasksResponse)APIUtils.doRequest(new SubmissionTasks(config, new SubmissionRequest(submissionId)));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Get the analyzed wordcount for a submission. A xxx response will be returned if the submission is not yet analyzed
    /// </summary>
    /// <returns>List of submission <see cref="SubmissionWordCountData">wordcount</see></returns>
    public List<SubmissionWordCountData> getSubmissionWordCount(Long submissionId) {
	SubmissionWordCountResponse response = (SubmissionWordCountResponse)APIUtils.doRequest(new SubmissionWordCount(config, new SubmissionRequest(submissionId)));
	return response.getResponseData().getWordcountData();
    }
    
    /// <summary>
    /// Get list of tasks for the specified connector instance using <see cref="TaskListRequest">TaskListRequest</see> object
    /// </summary>
    /// <returns>Paged list of submission <see cref="GCTask">tasks</see></returns>
    public TasksResponseData getTasksList(TaskListRequest request) {
	TasksResponse response = (TasksResponse)APIUtils.doRequest(new Tasks(config, request));
	return response.getResponseData();
    }
    
    /// <summary>
    /// Confirm delivery of the downloaded task
    /// </summary>
    /// <returns>Is success</returns>
    public Boolean confirmTask(Long taskId) {
	TasksConfirmResponse response = (TasksConfirmResponse)APIUtils.doRequest(new TasksConfirm(config, new TaskRequest(taskId)));
	return response.getResponseData().getIsSuccess();
    }
    
    /// <summary>
    /// Download the translated content for the specified task ID. If the taskID does not exist, or is not in a complete state, an error code XYZ will be returned
    /// </summary>
    /// <returns>Downloaded task as InputStream</returns>
    public InputStream downloadTask(Long taskId) throws IOException {
	return APIUtils.doDownload(new TasksDownload(config, new TaskRequest(taskId)));
    }
/*
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
    public JobListResponse jobListWithLocale(JobListRequest request) {
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
    public FileListResponse getUnsubmittedFiles() {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_UNSUBMITTED, new GCRequest());
	return new FileListResponse(response);
    }

    /// <summary>
    /// List the file(s) uploaded that have not been assigned to a translation
    /// job
    /// </summary>
    /// <param name="request">[Optional] <see
    /// cref="PageableRequest">Request</see> to specify page size and page
    /// number</param>
    /// <returns>The list of unsubmited <see cref="GCFile">files</see></returns>
    public FileListResponse getUnsubmittedFiles(PageableRequest request) {
	GCResponse response = APIUtils.doRequest(config, APIUtils.REQUEST_TASK_UNSUBMITTED,
		request != null ? request : new GCRequest());
	return new FileListResponse(response);
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
    }*/
}
