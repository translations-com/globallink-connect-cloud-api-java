package org.gs4tr.gcc.restclient.request;

import java.util.Map;

public class UpdateSubmissionAttributeRequest extends SubmissionRequest {

	private Map<String, Object> attributes;

	public UpdateSubmissionAttributeRequest(Long submissionId, Map<String, Object> attributes) {
		super(submissionId);
		this.attributes = attributes;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
