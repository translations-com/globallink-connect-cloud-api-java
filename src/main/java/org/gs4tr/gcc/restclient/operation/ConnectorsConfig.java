package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.GCAttribute;
import org.gs4tr.gcc.restclient.model.LanguageDirection;
import org.gs4tr.gcc.restclient.model.LocaleConfig;
import org.gs4tr.gcc.restclient.model.Status;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectorsConfig extends GCOperation {

	public ConnectorsConfig(GCConfig config) {
		super(config);
	}

	private static final String REQUEST_URL = "connectors/config";
	private static final String REQUEST_METHOD = "GET";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		return REQUEST_URL;
	}

	@Override
	public GCRequest getRequestObject() {
		return null;
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return ConnectorsConfigResponse.class;
	}

	public static class ConnectorsConfigResponse extends GCResponse {

		@JsonProperty("response_data")
		private ConnectorsConfigResponseData connectorsConfigResponseData;

		public ConnectorsConfigResponseData getResponseData() {
			return connectorsConfigResponseData;
		}

		public void setResponseData(ConnectorsConfigResponseData connectorsConfigResponseData) {
			this.connectorsConfigResponseData = connectorsConfigResponseData;
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ConnectorsConfigResponseData {
		@JsonProperty("supported_locales")
		private List<LocaleConfig> supportedLocales;
		@JsonProperty("file_types")
		private List<String> fileTypes;
		@JsonProperty("language_directions")
		private List<LanguageDirection> languageDirections;
		@JsonProperty("workflows")
		private List<String> workflows;
		@JsonProperty("submission_options")
		private ConnectorsConfigSubmissionOptions submissionOptions;
		@JsonProperty("available_states")
		private ConnectorsConfigAvailableStates availableStates;

		public List<LocaleConfig> getSupportedLocales() {
			return supportedLocales;
		}

		public void setSupportedLocales(List<LocaleConfig> supportedLocales) {
			this.supportedLocales = supportedLocales;
		}

		public List<String> getFileTypes() {
			return fileTypes;
		}

		public void setFileTypes(List<String> fileTypes) {
			this.fileTypes = fileTypes;
		}

		public ConnectorsConfigSubmissionOptions getSubmissionOptions() {
			return submissionOptions;
		}

		public void setSubmissionOptions(ConnectorsConfigSubmissionOptions submissionOptions) {
			this.submissionOptions = submissionOptions;
		}

		public List<String> getWorkflows() {
			return workflows;
		}

		public void setWorkflows(List<String> workflows) {
			this.workflows = workflows;
		}

		public List<LanguageDirection> getLanguageDirections() {
			return languageDirections;
		}

		public void setLanguageDirections(List<LanguageDirection> languageDirections) {
			this.languageDirections = languageDirections;
		}

		public ConnectorsConfigAvailableStates getAvailableStates() {
			return availableStates;
		}

		public void setAvailableStates(ConnectorsConfigAvailableStates availableStates) {
			this.availableStates = availableStates;
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ConnectorsConfigAvailableStates {
		@JsonProperty("submission")
		private List<Status> submissionStatuses;
		@JsonProperty("job")
		private List<Status> jobStatuses;
		@JsonProperty("task")
		private List<Status> taskStatuses;

		public ConnectorsConfigAvailableStates() {

		}

		public List<Status> getSubmissionStatuses() {
			return submissionStatuses;
		}

		public void setSubmissionStatuses(List<Status> submissionStatuses) {
			this.submissionStatuses = submissionStatuses;
		}

		public List<Status> getJobStatuses() {
			return jobStatuses;
		}

		public void setJobStatuses(List<Status> jobStatuses) {
			this.jobStatuses = jobStatuses;
		}

		public List<Status> getTaskStatuses() {
			return taskStatuses;
		}

		public void setTaskStatuses(List<Status> taskStatuses) {
			this.taskStatuses = taskStatuses;
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ConnectorsConfigSubmissionOptions {
		@JsonProperty("attributes")
		private List<GCAttribute> attributes;

		@JsonProperty("config")
		private List<GCAttribute> config;

		public ConnectorsConfigSubmissionOptions() {

		}

		public List<GCAttribute> getAttributes() {
			return attributes;
		}

		public void setAttributes(List<GCAttribute> attributes) {
			this.attributes = attributes;
		}

		public List<GCAttribute> getConfig() {
			return config;
		}

		public void setConfig(List<GCAttribute> config) {
			this.config = config;
		}

	}
}