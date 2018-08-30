package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionStart extends GCOperation {

    private static final String REQUEST_URL = "session/start";
    private static final String REQUEST_METHOD = "POST";

    public SessionStart(GCConfig config) {
	super(config);
    }
    
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
	return new SessionStartRequest(config.getUserName(), config.getPassword(), config.getUserAgent());
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return SessionStartResponse.class;
    }

    public class SessionStartRequest extends GCRequest {
	private final String username;
	private final String password;
	private final String user_agent;

	public SessionStartRequest(String username, String password, String user_agent) {
	    this.username = username;
	    this.password = password;
	    this.user_agent = user_agent;
	}

	public String getUsername() {
	    return username;
	}

	public String getPassword() {
	    return password;
	}

	public String getUser_agent() {
	    return user_agent;
	}
    }

    public static class SessionStartResponse extends GCResponse {
	
	public SessionStartResponse(){}

	@JsonProperty("response_data")
	private SessionStartResponseData sessionStartResponseData;

	public SessionStartResponseData getResponseData() {
	    return sessionStartResponseData;
	}

	public void setResponseData(SessionStartResponseData sessionStartResponseData) {
	    this.sessionStartResponseData = sessionStartResponseData;
	}

    }

    public static class SessionStartResponseData {
	@JsonProperty("user_session_key")
	private String userSessionKey;
	
	public SessionStartResponseData(){}

	public String getUserSessionKey() {
	    return userSessionKey;
	}

	public void setUserSessionKey(String userSessionKey) {
	    this.userSessionKey = userSessionKey;
	}
    }

}
