package org.gs4tr.gcc.restclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordcountRequest extends GCRequest {

    @JsonProperty("job_id")
    private Long jobId;

    public WordcountRequest(Long jobId) {
	this.jobId = jobId;
    }

}
