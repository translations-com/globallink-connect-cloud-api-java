package org.gs4tr.gcc.restclient.operation;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCSimpleResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login extends GCOperation {

	private static final String REQUEST_URL = "login";
	private static final String REQUEST_METHOD = "POST";

	public Login(GCConfig config) {
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
	public Class<? extends GCSimpleResponse> getResponseClass() {
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

	public static class SessionStartResponse extends GCSimpleResponse {

		@JsonProperty("access_token")
		private String accessToken;
		@JsonProperty("token_type")
		private String type;
		@JsonProperty("expires_in")
		private Long expiresIn;

		public SessionStartResponse() {
		}

		public String getAccessToken() {
			return accessToken;
		}

		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Long getExpiresIn() {
			return expiresIn;
		}

		public void setExpiresIn(Long expiresIn) {
			this.expiresIn = expiresIn;
		}

	}

}
