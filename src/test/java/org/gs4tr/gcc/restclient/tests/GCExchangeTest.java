package org.gs4tr.gcc.restclient.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.GCExchange;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.model.Connector;
import org.gs4tr.gcc.restclient.model.GCJob;
import org.gs4tr.gcc.restclient.model.GCSubmission;
import org.gs4tr.gcc.restclient.model.GCTask;
import org.gs4tr.gcc.restclient.model.HistoryItem;
import org.gs4tr.gcc.restclient.model.JobStatus;
import org.gs4tr.gcc.restclient.model.LocaleConfig;
import org.gs4tr.gcc.restclient.model.LogEntry;
import org.gs4tr.gcc.restclient.model.SubmissionStatus;
import org.gs4tr.gcc.restclient.model.TaskStatus;
import org.gs4tr.gcc.restclient.operation.ConnectorsConfig.ConnectorsConfigResponseData;
import org.gs4tr.gcc.restclient.operation.Jobs.JobsResponseData;
import org.gs4tr.gcc.restclient.operation.SubmissionSubmit.SubmissionSubmitResponseData;
import org.gs4tr.gcc.restclient.operation.Submissions.SubmissionsResponseData;
import org.gs4tr.gcc.restclient.operation.Tasks.TasksResponseData;
import org.gs4tr.gcc.restclient.request.CheckHistoryRequest;
import org.gs4tr.gcc.restclient.request.JobListRequest;
import org.gs4tr.gcc.restclient.request.JobTasksRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;
import org.gs4tr.gcc.restclient.request.SubmissionSubmitRequest;
import org.gs4tr.gcc.restclient.request.SubmissionsListRequest;
import org.gs4tr.gcc.restclient.request.TaskListRequest;
import org.gs4tr.gcc.restclient.request.UpdateSubmissionAttributeRequest;
import org.gs4tr.gcc.restclient.request.UpdateTasksMetadataRequest;
import org.gs4tr.gcc.restclient.request.UploadFileContextRequest;
import org.gs4tr.gcc.restclient.request.UploadFileContextRequest.ContextType;
import org.gs4tr.gcc.restclient.request.UploadFileRequest;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class GCExchangeTest {
	//remove all comments and set connection info
	private static String username = "username";
	private static String password = "password";
	private static String url = "https://url/api/v3";
	private static String connector_key = "aa11a11aaa1111111aaaa111aaa1aa11";

	private static GCExchange xchange;
	private static Boolean isConfigured;

	static {
		if(!"username".equals(username)) {
			GCConfig config = new GCConfig(url, username, password, connector_key);
			xchange = new GCExchange(config);
			xchange.getConfig().getLogger().setLevel(Level.ALL);
			isConfigured = true;
		} else {
			xchange = null;
			isConfigured = false;
		}
	}

	@Before
	public void setUp() {
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

			public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
				return true;
			}
		});
	}

	@Test
	public void testInit() {
		if(!isConfigured) {
			return;
		}
		try {
			new GCExchange(new GCConfig("", username, password));
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			new GCExchange(new GCConfig(url, "", password));
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		try {
			new GCExchange(new GCConfig(url, username, null));
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testConnectors() {
		if(!isConfigured) {
			return;
		}
		List<Connector> connectors = xchange.getConnectors();
		assertNotNull(connectors);
		assertTrue(connectors.size() > 0);
		for (Connector c : connectors) {
			assertFalse(isNullOrEmpty(c.getConnectorKey()));
			assertFalse(isNullOrEmpty(c.getConnectorName()));
		}

		ConnectorsConfigResponseData cc = xchange.getConnectorsConfig();
		assertNotNull(cc.getSupportedLocales());
		assertTrue(cc.getSupportedLocales().size() > 0);
		for (LocaleConfig lc : cc.getSupportedLocales()) {
			assertFalse(isNullOrEmpty(lc.getConnectorLocale()));
		}

		String info = xchange.getConnectorsInfo();
		xchange.getConfig().getLogger().info(info);
	}

	@Test
	public void testDatastore() throws JsonParseException, JsonMappingException, IOException {
		if(!isConfigured) {
			return;
		}
		xchange.getConfig().getLogger().info("token:" + xchange.getSessionToken());
		List<String> dataStoreKeys = xchange.getDataStoreKeys();
		xchange.getConfig().getLogger().info(String.join(", ", dataStoreKeys));
		List<Linkage> dataStoreEntry = xchange.getDataStoreEntryAsList("linkage", Linkage.class);
		String dataStoreEntryJson2 = xchange.getDataStoreEntryJson("second");
		xchange.getConfig().getLogger().info(dataStoreEntryJson2);
		String dataStoreEntryAsObject = xchange.getDataStoreEntryAsObject("second", String.class);
		xchange.getConfig().getLogger().info(dataStoreEntryAsObject);
		for (Linkage l : dataStoreEntry) {
			xchange.getConfig().getLogger()
					.info("Linkage:" + l.getId() + ":" + l.getPublicationTitle() + ":" + l.getIsMaster());
		}

		MessageResponse addOrUpdateDataStore = xchange.addOrUpdateDataStore("testobject",
				new TestObject("string", true, 11L));
		xchange.getConfig().getLogger().info(addOrUpdateDataStore.getMessage());
		addOrUpdateDataStore = xchange.addOrUpdateDataStore("testobject", new TestObject("string2", true, 12L));
		dataStoreEntryJson2 = xchange.getDataStoreEntryJson("testobject");
		xchange.getConfig().getLogger().info(dataStoreEntryJson2);
		TestObject fromServer = xchange.getDataStoreEntryAsObject("testobject", TestObject.class);
		xchange.getConfig().getLogger()
				.info(fromServer.stringField + ":" + fromServer.boolField + ":" + fromServer.longField);

		MessageResponse deleteDataStoreKeys = xchange.deleteDataStoreKeys(Arrays.asList("testobject"));
		xchange.getConfig().getLogger().info(deleteDataStoreKeys.getMessage());
	}

	@Test
	public void testSubmission() {
		if(!isConfigured) {
			return;
		}
		UploadFileRequest request = new UploadFileRequest("test contents for upload".getBytes(), "sergei_test.xml",
				"XML");
		String uuid = UUID.randomUUID().toString();
		request.setUniqueIdentifier(uuid);
		String uploadContent = xchange.uploadContent(request);
		xchange.getConfig().getLogger().info("UPLOADED:" + uploadContent);
		
		UploadFileContextRequest uploadFileContextRequest = new UploadFileContextRequest(new String("test contents").getBytes(), ContextType.HTML);
		String uploadContext = xchange.uploadContext(uploadFileContextRequest);
		xchange.getConfig().getLogger().info("UPLOADED context:" + uploadContext);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		SubmissionSubmitRequest sr = new SubmissionSubmitRequest("test sub", cal.getTime(), "en-US",
				Arrays.asList("de-DE", "fr-FR"), Arrays.asList(uploadContent));
		SubmissionSubmitResponseData submitSubmission = xchange.submitSubmission(sr);
		xchange.getConfig().getLogger().info("Started sub " + submitSubmission.getSubmissionId());

		List<HistoryItem> items = Arrays.asList(new HistoryItem(uuid, "XML"));
		CheckHistoryRequest r = new CheckHistoryRequest("en-US", Arrays.asList("de-DE", "fr-FR"), items);
		xchange.checkHistory(r);

		SubmissionsListRequest slr = new SubmissionsListRequest();
		List<Connector> connectors = xchange.getConnectors();
		List<String> connectorIds = new ArrayList<String>();
		for(Connector connector : connectors) {
			connectorIds.add(connector.getConnectorKey());
		}
		slr.setConnectorIds(connectorIds);
		slr.setSubmissionStatuses(new SubmissionStatus[] { SubmissionStatus.Completed });
		SubmissionsResponseData submissionsList = xchange.getSubmissionsList(slr);
		for (GCSubmission sub : submissionsList.getSubmissions()) {
			xchange.getConfig().getLogger().info("Submission " + sub.getSubmissionName());
		}
		if (submissionsList.getSubmissions() != null && submissionsList.getSubmissions().size() > 0) {
			xchange.setConnectorKey(submissionsList.getSubmissions().get(0).getConnectorKey());
			xchange.getSubmissionTasks(
					new SubmissionRequest(submissionsList.getSubmissions().get(0).getSubmissionId()));
			xchange.getSubmissionJobs(submissionsList.getSubmissions().get(0).getSubmissionId());
			xchange.getSubmissionStatus(submissionsList.getSubmissions().get(0).getSubmissionId());
			xchange.getSubmissionWordCount(submissionsList.getSubmissions().get(0).getSubmissionId());
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("key1", "value1");
			attr.put("key2", 2);
			xchange.updateSubmissionAttributes(new UpdateSubmissionAttributeRequest(
					submissionsList.getSubmissions().get(0).getSubmissionId(), attr));
			xchange.setConnectorKey(connector_key);
		}

		JobListRequest jlr = new JobListRequest();
		jlr.setJobStatuses(new JobStatus[] { JobStatus.Completed });
		JobsResponseData jobsList = xchange.getJobsList(jlr);
		for (GCJob job : jobsList.getJobs()) {
			xchange.getConfig().getLogger().info("Job " + job.getSubmissionName() + ":" + job.getJobId());
		}
		if (jobsList.getJobs() != null && jobsList.getJobs().size() > 0) {
			xchange.getJobTasks(new JobTasksRequest(jobsList.getJobs().get(0).getJobId(), 1L, 10L));
			xchange.getJobStatus(jobsList.getJobs().get(0).getJobId());
			xchange.getJobWordCount(jobsList.getJobs().get(0).getJobId());
		}

		TaskListRequest tlr = new TaskListRequest();
		tlr.setStatuses(new String[] { TaskStatus.Completed.text() });
		TasksResponseData tasksList = xchange.getTasksList(tlr);
		for (GCTask task : tasksList.getTasks()) {
			xchange.getConfig().getLogger().info("Task " + task.getTaskId() + ":" + task.getSourceLocale().getLocale()
					+ "->" + task.getTargetLocale().getLocale());
		}
		if (tasksList.getTasks().size() > 0) {
			GCTask task = tasksList.getTasks().get(0);
			Map<String, Object> metadata = new HashMap<String, Object>();
			metadata.put("key1", "value1");
			metadata.put("key2", 2);
			xchange.updateTaskMetadata(new UpdateTasksMetadataRequest(Arrays.asList(task.getTaskId()), metadata));
			InputStream downloadTask = xchange.downloadTask(task.getTaskId());
			String text = null;
			try (Scanner scanner = new Scanner(downloadTask, StandardCharsets.UTF_8.name())) {
				text = scanner.useDelimiter("\\A").next();
			}
			System.out.println("Translated:" + text);
			xchange.confirmTask(task.getTaskId());
		}
		if (tasksList.getTasks().size() > 1) {
			xchange.getConfig().getLogger()
					.info(xchange.cancelTask(tasksList.getTasks().get(1).getTaskId()).getMessage());
			xchange.getConfig().getLogger()
					.info(xchange.confirmTaskCancellation(tasksList.getTasks().get(1).getTaskId()).getMessage());
		}
	}

	@Test
	public void testOther() {
		if(!isConfigured) {
			return;
		}
		List<LogEntry> logs = Arrays.asList(new LogEntry("INFO", new Date(), "message1", "origin1"),
				new LogEntry("INFO", new Date(), "message1", "origin1"));
		xchange.addLog(logs);
		xchange.getContentList();
		xchange.getContextConfigs();
		// xchange.notify(new NotifyRequest("notify message"));

	}

	private Boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() <= 0;
	}

	public static class TestObject {
		private String stringField;
		private Boolean boolField;
		private Long longField;

		public TestObject() {

		}

		public TestObject(String stringValue, Boolean booleanValue, Long longValue) {
			this.stringField = stringValue;
			this.boolField = booleanValue;
			this.longField = longValue;
		}

		public String getStringField() {
			return stringField;
		}

		public void setStringField(String stringField) {
			this.stringField = stringField;
		}

		public Boolean getBoolField() {
			return boolField;
		}

		public void setBoolField(Boolean boolField) {
			this.boolField = boolField;
		}

		public Long getLongField() {
			return longField;
		}

		public void setLongField(Long longField) {
			this.longField = longField;
		}

	}

	public static class Linkage {
		@JsonProperty("Id")
		private Long id;
		@JsonProperty("PublicationTitle")
		private String publicationTitle;
		@JsonProperty("IsMaster")
		private Boolean isMaster;
		@JsonProperty("GroupId")
		private Long groupId;
		@JsonProperty("LangConfigId")
		private Long langConfigId;
		@JsonProperty("IsAppMaster")
		private Boolean isAppMaster;

		public Linkage() {

		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPublicationTitle() {
			return publicationTitle;
		}

		public void setPublicationTitle(String publicationTitle) {
			this.publicationTitle = publicationTitle;
		}

		public Boolean getIsMaster() {
			return isMaster;
		}

		public void setIsMaster(Boolean isMaster) {
			this.isMaster = isMaster;
		}

		public Long getGroupId() {
			return groupId;
		}

		public void setGroupId(Long groupId) {
			this.groupId = groupId;
		}

		public Long getLangConfigId() {
			return langConfigId;
		}

		public void setLangConfigId(Long langConfigId) {
			this.langConfigId = langConfigId;
		}

		public Boolean getIsAppMaster() {
			return isAppMaster;
		}

		public void setIsAppMaster(Boolean isAppMaster) {
			this.isAppMaster = isAppMaster;
		}

	}
}
