package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class SessionTerminate extends GCOperation {

    private static final String REQUEST_URL = "session/terminate";
    private static final String REQUEST_METHOD = "POST";

    public SessionTerminate(GCConfig config) {
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
	return new SessionTerminateRequest(config.getBearerToken());
    }

    @Override
    public Class<? extends GCResponse> getResponseClass() {
	return SessionTerminateResponse.class;
    }

    public class SessionTerminateRequest extends GCRequest {
	private final String user_session_key;

	public SessionTerminateRequest(String user_session_key) {
	    this.user_session_key = user_session_key;
	}

	public String getUser_session_key() {
	    return user_session_key;
	}

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SessionTerminateResponse extends GCResponse {
	

	@Override
	public Object getResponseData() {
	    return null;
	}

    }

}
