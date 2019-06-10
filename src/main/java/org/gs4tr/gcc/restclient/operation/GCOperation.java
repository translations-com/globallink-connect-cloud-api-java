package org.gs4tr.gcc.restclient.operation;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class GCOperation {

    protected GCConfig config;

    public GCOperation(GCConfig config) {
	this.setConfig(config);
    }

    protected abstract String getApiUrl();

    public abstract GCRequest getRequestObject();

    public abstract Class<? extends GCResponse> getResponseClass();

    public abstract String getRequestMethod();
    
    public Boolean allowErrorResponse(){
	return false;
    }
    
    public String getRequestJson(){
	return null;
    }

    public URL getRequestUrl() throws MalformedURLException {
	if (getRequestObject() != null && getRequestMethod().equalsIgnoreCase("GET")) {
	    ObjectMapper mapper = new ObjectMapper();
	    @SuppressWarnings("unchecked")
	    Map<String, Object> map = mapper.convertValue(getRequestObject(), Map.class);
	    StringBuilder query = new StringBuilder();
	    boolean first = true;
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
		try {
		    if (entry.getValue() == null
			    || (entry.getValue() instanceof Long && ((Long) entry.getValue()) == 0)) {
			continue;
		    }
		    if (first) {
			first = false;

		    } else {
			query.append("&");
		    }
		    query.append(entry.getKey()).append("=").append(URLEncoder.encode("" + entry.getValue(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		}
	    }
	    if (query.toString().length() > 0) {
		return new URL(config.getApiUrl() + getApiUrl() + "?" + query.toString());
	    } else {
		return new URL(config.getApiUrl() + getApiUrl());
	    }
	}
	return new URL(config.getApiUrl() + getApiUrl());
    }

    public GCConfig getConfig() {
	return config;
    }

    public void setConfig(GCConfig config) {
	this.config = config;
    }
}
