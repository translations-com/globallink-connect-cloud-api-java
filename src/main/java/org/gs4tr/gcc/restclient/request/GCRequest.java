package org.gs4tr.gcc.restclient.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class GCRequest {

    public GCRequest() {
    }

    @JsonIgnore
    public Map<String, Object> getParameters() {
	return new HashMap<String, Object>();
    }

}
