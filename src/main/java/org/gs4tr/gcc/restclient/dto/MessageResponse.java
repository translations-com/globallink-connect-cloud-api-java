package org.gs4tr.gcc.restclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MessageResponse extends GCResponse {

    @Override
    public Object getResponseData() {
	return null;
    }

}
