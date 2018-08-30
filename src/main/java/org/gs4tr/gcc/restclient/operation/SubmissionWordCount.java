package org.gs4tr.gcc.restclient.operation;

import java.util.List;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.SubmissionWordCountData;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.request.SubmissionRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionWordCount extends GCOperation {

    private final SubmissionRequest request;

    public SubmissionWordCount(GCConfig config, SubmissionRequest request) {
	super(config);
	this.request = request;
    }

    private static final String REQUEST_URL = "submissions/wordcount";
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
	return getRequest();
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return SubmissionWordCountResponse.class;
    }

    public SubmissionRequest getRequest() {
	return request;
    }

    public static class SubmissionWordCountResponse extends GCResponse {

	@JsonProperty("response_data")
	private SubmissionWordCountResponseData responseData;

	public SubmissionWordCountResponseData getResponseData() {
	    return responseData;
	}

	public void setResponseData(SubmissionWordCountResponseData responseData) {
	    this.responseData = responseData;
	}

    }

    public static class SubmissionWordCountResponseData {
	@JsonProperty("wordcount_data")
	private List<SubmissionWordCountData> wordcountData;

	public List<SubmissionWordCountData> getWordcountData() {
	    return wordcountData;
	}

	public void setWordcountData(List<SubmissionWordCountData> wordcountData) {
	    this.wordcountData = wordcountData;
	}

    }
}
