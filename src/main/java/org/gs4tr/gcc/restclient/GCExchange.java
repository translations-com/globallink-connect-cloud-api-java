package org.gs4tr.gcc.restclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.model.Connector;
import org.gs4tr.gcc.restclient.model.GCFile;
import org.gs4tr.gcc.restclient.model.GCJob;
import org.gs4tr.gcc.restclient.model.GCSubmission;
import org.gs4tr.gcc.restclient.model.GCTask;
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
import org.gs4tr.gcc.restclient.operation.JobCancel;
import org.gs4tr.gcc.restclient.operation.JobStatus;
import org.gs4tr.gcc.restclient.operation.JobStatus.StatusResponse;
import org.gs4tr.gcc.restclient.operation.JobTasks;
import org.gs4tr.gcc.restclient.operation.JobWordCount;
import org.gs4tr.gcc.restclient.operation.JobWordCount.JobWordCountResponse;
import org.gs4tr.gcc.restclient.operation.Jobs;
import org.gs4tr.gcc.restclient.operation.Jobs.JobsResponse;
import org.gs4tr.gcc.restclient.operation.Jobs.JobsResponseData;
import org.gs4tr.gcc.restclient.operation.SessionStart;
import org.gs4tr.gcc.restclient.operation.SessionStart.SessionStartResponse;
import org.gs4tr.gcc.restclient.operation.SessionTerminate;
import org.gs4tr.gcc.restclient.operation.SubmissionCancel;
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
import org.gs4tr.gcc.restclient.operation.Submissions;
import org.gs4tr.gcc.restclient.operation.Submissions.SubmissionsResponse;
import org.gs4tr.gcc.restclient.operation.Submissions.SubmissionsResponseData;
import org.gs4tr.gcc.restclient.operation.Tasks;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponse;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponseData;
import org.gs4tr.gcc.restclient.operation.TasksConfirm;
import org.gs4tr.gcc.restclient.operation.TasksConfirm.TasksConfirmResponse;
import org.gs4tr.gcc.restclient.operation.TasksConfirmCancellation;
import org.gs4tr.gcc.restclient.operation.TasksConfirmCancellation.TaskConfirmCancellationFailure;
import org.gs4tr.gcc.restclient.operation.TasksConfirmCancellation.TasksConfirmCancellationResponse;
import org.gs4tr.gcc.restclient.operation.TasksDownload;
import org.gs4tr.gcc.restclient.operation.TasksError;
import org.gs4tr.gcc.restclient.request.JobListRequest;
import org.gs4tr.gcc.restclient.request.JobRequest;
import org.gs4tr.gcc.restclient.request.PageableRequest;
import org.gs4tr.gcc.restclient.request.SubmissionCreateRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;
import org.gs4tr.gcc.restclient.request.SubmissionSubmitRequest;
import org.gs4tr.gcc.restclient.request.SubmissionsListRequest;
import org.gs4tr.gcc.restclient.request.TaskErrorRequest;
import org.gs4tr.gcc.restclient.request.TaskListRequest;
import org.gs4tr.gcc.restclient.request.TaskRequest;
import org.gs4tr.gcc.restclient.request.TasksRequest;
import org.gs4tr.gcc.restclient.request.UploadContentReferenceRequest;
import org.gs4tr.gcc.restclient.request.UploadFileContextRequest;
import org.gs4tr.gcc.restclient.request.UploadFileRequest;
import org.gs4tr.gcc.restclient.util.APIUtils;
import org.gs4tr.gcc.restclient.util.StringUtils;
import org.w3c.dom.DOMException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GCExchange {
    private GCConfig config = null;

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
	if(StringUtils.IsNullOrWhiteSpace(conf.getBearerToken())) {
	    if (StringUtils.IsNullOrWhiteSpace(conf.getUserName())) {
		throw new IllegalArgumentException("Username is required");
	    }
	    if (StringUtils.IsNullOrWhiteSpace(conf.getPassword())) {
		throw new IllegalArgumentException("Password is required");
	    }
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
    
    /**
     * Terminate session
     * 
     * @return Is success
     */
    public Boolean logout() {
	APIUtils.doRequest(new SessionTerminate(config));
	return true;
    }
    
    public void setConnectorKey(String connectorKey) {
	config.setConnectorKey(connectorKey);
    }
    
    /**
     * Get session token created during automated session start
     * 
     * @return Session token
     */
    public String getSessionToken() {
	return config.getBearerToken();
    }
    
    /**
     * Gets listing of all connectors available to the user
     * 
     * @return List of {@link Connector}
     */
    public List<Connector> getConnectors() {
	ConnectorsResponse response = (ConnectorsResponse)APIUtils.doRequest(new Connectors(config));
	return response.getResponseData();
    }
    
    /**
     * Gets connector config for specified connector token, which includes filetypes, locales and submission config options
     * 
     * @return Connector config as {@link ConnectorsConfigResponseData} including supported locales and file types
     */
    public ConnectorsConfigResponseData getConnectorsConfig() {
	ConnectorsConfigResponse response = (ConnectorsConfigResponse)APIUtils.doRequest(new ConnectorsConfig(config));
	return response.getResponseData();
    }
    
    /**
     * Returns a list of all content objects that have been uploaded for the specified connector that have not yet been submitted
     * 
     * @return Paged list of {@link GCFile}
     */
    public ContentResponseData getContentList() {
	ContentResponse response = (ContentResponse)APIUtils.doRequest(new Content(this.config));
	return response.getResponseData();
    }
    
    /**
     * Returns a list of all content objects that have been uploaded for the specified connector that have not yet been submitted
     * 
     * @param request {@link PageableRequest}
     * @return Paged list of {@link GCFile}
     */
    public ContentResponseData getContentList(PageableRequest request) {
	ContentResponse response = (ContentResponse)APIUtils.doRequest(new Content(this.config, request));
	return response.getResponseData();
    }
    
    /**
     * Upload content for translation. The returned content-id can be used to create a submission
     * 
     * @param request {@link UploadFileRequest}
     * @return Id of uploaded content
     */
    public String uploadContent(UploadFileRequest request){
	ContentDataResponse response = (ContentDataResponse)APIUtils.doRequestWithParameters(new ContentData(config, request));
	return response.getResponseData().getContentId();
    }
    
    /**
     * Upload a reference file which will be associated with the submission and will be available to the translator and reviewer.
     * 
     * @param request {@link UploadContentReferenceRequest}
     * @return Id of uploaded reference
     */
    public String uploadContentReference(UploadContentReferenceRequest request){
	ContentReferenceResponse response = (ContentReferenceResponse)APIUtils.doRequestWithParameters(new ContentReference(config, request));
	return response.getResponseData().getReferenceId();
    }
    
    /**
     * Get a list of all confgured XSLT profiles, for the specified connector
     * 
     * @return List of XSLT profiles
     */
    public List<String> getContextConfigs(){
	ContextConfigResponse response = (ContextConfigResponse)APIUtils.doRequest(new ContextConfig(config));
	return response.getResponseData().getXsltConfigs();
    }
    
    /**
     * Upload context. The returned static url can be used when uploading content
     * 
     * @param request {@link UploadFileContextRequest}
     * @return Static preview url of uploaded context
     */
    public String uploadContext(UploadFileContextRequest request){
	ContextResponse response = (ContextResponse)APIUtils.doRequestWithParameters(new Context(config, request));
	return response.getResponseData().getStaticUrl();
    }
    
    /**
     * Get list of jobs for the specified connector instance
     * 
     * @param request {@link JobListRequest}
     * @return Paged list of {@link GCJob}
     */
    public JobsResponseData getJobsList(JobListRequest request) {
	JobsResponse response = (JobsResponse)APIUtils.doRequest(new Jobs(config, request));
	return response.getResponseData();
    }
    
    /**
     * Get the status of the Job
     * 
     * @param jobId Job Id
     * @return {@link State}
     */
    public State getJobState(Long jobId) {
	StatusResponse response = (StatusResponse)APIUtils.doRequest(new JobStatus(config, new JobRequest(jobId)));
	return response.getResponseData();
    }
    
    /**
     * Gets the tasks list for the specified job
     * 
     * @param jobRequest {@link JobRequest}
     * @return Paged list of {@link GCTask}
     */
    public TasksResponseData getJobTasks(JobRequest jobRequest) {
	TasksResponse response = (TasksResponse)APIUtils.doRequest(new JobTasks(config, jobRequest));
	return response.getResponseData();
    }
    
    /**
     * Get the analyzed wordcount for a job. A xxx response will be returned if the submission is not yet analyzed
     * 
     * @param jobId Job Id
     * @return List of {@link WordCountSummary}
     */
    public List<WordCountSummary> getJobWordCount(Long jobId) {
	JobWordCountResponse response = (JobWordCountResponse)APIUtils.doRequest(new JobWordCount(config, new JobRequest(jobId)));
	return response.getResponseData();
    }
    
    /**
     * Get list of submissions for the specified connector instance
     * 
     * @return Paged list of {@link GCSubmission}
     */
    public SubmissionsResponseData getSubmissionsList() {
	SubmissionsResponse response = (SubmissionsResponse)APIUtils.doRequest(new Submissions(config, null));
	return response.getResponseData();
    }
    
    /**
     * Get list of submissions for the specified connector instance
     * 
     * @param request {@link SubmissionsListRequest}
     * @return Paged list of {@link GCSubmission}
     */
    public SubmissionsResponseData getSubmissionsList(SubmissionsListRequest request) {
	SubmissionsResponse response = (SubmissionsResponse)APIUtils.doRequest(new Submissions(config, request));
	return response.getResponseData();
    }
    
    /**
     * Create a submission from node-ids. The list of node-ids is provided by the plugin that is installed in the client system Notes: 1."connector_locale" is case sensitive 2.Only child nodes(is_parent: 0) can be sent for translation
     * 
     * @param request {@link SubmissionCreateRequest}
     * @return Id of created submission
     */
    public Long createSubmission(SubmissionCreateRequest request) {
	SubmissionCreateResponse response = (SubmissionCreateResponse)APIUtils.doRequest(new SubmissionCreate(config, request));
	return response.getResponseData().getSubmissionId();
    }
    
    /**
     * Gets the jobs list for the specified submission
     * 
     * @param submissionId Submission Id
     * @return Paged list of {@link GCJob}
     */
    public JobsResponseData getSubmissionJobs(Long submissionId) {
	JobsResponse response = (JobsResponse)APIUtils.doRequest(new SubmissionJobs(config, new SubmissionRequest(submissionId)));
	return response.getResponseData();
    }
    
    /**
     * Get the status of the submission
     * 
     * @param submissionId Submission Id
     * @return Submission {@link State}
     */
    public State getSubmissionState(Long submissionId) {
	StatusResponse response = (StatusResponse)APIUtils.doRequest(new SubmissionStatus(config, new SubmissionRequest(submissionId)));
	return response.getResponseData();
    }
    
    /**
     * Cancel submission
     * 
     * @param submissionId Submission Id
     * @return MessageResponse {@link MessageResponse} response with status and message
     */
    public MessageResponse cancelSubmission(Long submissionId) {
	MessageResponse response = (MessageResponse)APIUtils.doRequest(new SubmissionCancel(config, new SubmissionRequest(submissionId)));
	return response;
    }
    
    /**
     * Cancel job
     * 
     * @param jobId Job Id
     * @return MessageResponse {@link MessageResponse} response with status and message
     */
    public MessageResponse cancelJob(Long jobId) {
	MessageResponse response = (MessageResponse)APIUtils.doRequest(new JobCancel(config, new JobRequest(jobId)));
	return response;
    }
    
    /**
     * Submit a list of one or more content objects (content-ids) to one ore more target languages Notes: 1."connector_locale" is case sensitive 2.Only child nodes(is_parent: 0) can be sent for translation
     * 
     * @param request {@link SubmissionSubmitRequest}
     * @return {@link SubmissionSubmitResponseData} object which contains submission id and jobs
     */
    public SubmissionSubmitResponseData submitSubmission(SubmissionSubmitRequest request) {
	SubmissionSubmitResponse response = (SubmissionSubmitResponse)APIUtils.doRequest(new SubmissionSubmit(config, request));
	return response.getResponseData();
    }
    
    /**
     * Gets the tasks list for the specified submission
     * 
     * @param request SubmissionRequest
     * @return Paged list of {@link GCTask}
     */
    public TasksResponseData getSubmissionTasks(SubmissionRequest request) {
	TasksResponse response = (TasksResponse)APIUtils.doRequest(new SubmissionTasks(config, request));
	return response.getResponseData();
    }
    
    /**
     * Get the analyzed wordcount for a submission. A xxx response will be returned if the submission is not yet analyzed
     * 
     * @param submissionId Submission Id
     * @return List of submission {@link SubmissionWordCountData}
     */
    public List<SubmissionWordCountData> getSubmissionWordCount(Long submissionId) {
	SubmissionWordCountResponse response = (SubmissionWordCountResponse)APIUtils.doRequest(new SubmissionWordCount(config, new SubmissionRequest(submissionId)));
	return response.getResponseData().getWordcountData();
    }
    
    /**
     * Get list of tasks for the specified connector instance
     * 
     * @param request {@link TaskListRequest}
     * @return Paged list of {@link GCTask}
     */
    public TasksResponseData getTasksList(TaskListRequest request) {
	TasksResponse response = (TasksResponse)APIUtils.doRequest(new Tasks(config, request));
	return response.getResponseData();
    }
    
    /**
     * Set the Job tasks error for given task
     * 
     * @param request {@link TaskErrorRequest}
     * @return MessageResponse {@link MessageResponse} response with status and message
     */
    public MessageResponse setTaskError(TaskErrorRequest request) {
	MessageResponse response = (MessageResponse)APIUtils.doRequest(new TasksError(config, request));
	return response;
    }
    
    /**
     * Confirm delivery of the downloaded task
     * 
     * @param taskId Task Id
     * @return Is success
     */
    public Boolean confirmTask(Long taskId) {
	TasksConfirmResponse response = (TasksConfirmResponse)APIUtils.doRequest(new TasksConfirm(config, new TaskRequest(taskId)));
	return response.getResponseData().getIsSuccess();
    }
    
    /**
     * Confirm that cancelled task is processed on client side
     * 
     * @param taskIds List of Task Ids to confirm cancellation
     * @return  List of confirm cancellation failures. If list is empty, then result is success for all specified task ids
     */
    public List<TaskConfirmCancellationFailure> confirmTaskCancellation(List<Long> taskIds) {
	TasksConfirmCancellationResponse response = (TasksConfirmCancellationResponse)APIUtils.doRequest(new TasksConfirmCancellation(config, new TasksRequest(taskIds)));
	return response.getResponseData().getTaskConfirmCancellationFailures();
    }
    
    /**
     * Download the translated content for the specified task ID. If the taskID does not exist, or is not in a complete state, an error code XYZ will be returned
     * 
     * @param taskId Task Id
     * @return Completed task data as InputStream
     */
    public InputStream downloadTask(Long taskId) {
	return APIUtils.doDownload(new TasksDownload(config, new TaskRequest(taskId)));
    }
    
    /**
     * Utility method. Creates json from object
     * 
     * @param object Object to create json
     * @return Requested object in json format
     * @throws JsonProcessingException Json generation exception
     */
    public String createJson(Object object) throws JsonProcessingException {
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString(object);
    }
    
    /**
     * Utility method. Create object of requested class from json
     * 
     * @param json Json string
     * @param outputClass Output class
     * @return Object created from json
     * @throws IOException Json parsing exception
     * @throws JsonMappingException Json parsing exception
     * @throws JsonParseException Json parsing exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object parseJson(String json, Class outputClass) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	return mapper.readValue(json, outputClass);
    }

}
