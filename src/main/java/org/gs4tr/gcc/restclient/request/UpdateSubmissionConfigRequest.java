package org.gs4tr.gcc.restclient.request;

import java.util.Map;

public class UpdateSubmissionConfigRequest extends SubmissionRequest {

	private Map<String, Object> config;

	public UpdateSubmissionConfigRequest(Long submissionId, Map<String, Object> config) {
		super(submissionId);
		this.config = config;
	}

	public Map<String, Object> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

}