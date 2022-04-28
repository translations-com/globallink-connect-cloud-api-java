package org.gs4tr.gcc.restclient;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GCConfig {

	private String apiUrl;
	private String userName;
	private String password;
	private String connectorKey;
	private String userAgent;
	private String trustStorePath;
    private String trustStorePassword;
	private GCProxyConfig proxyConfig;
	private Map<String, String> customHeaders = new HashMap<>();

	private String bearerToken;
	
	private String apiKey;

	private Logger logger;

	private GCConfig() {
		logger = Logger.getLogger(GCExchange.class.getName());
		logger.setLevel(Level.OFF);
	}

	/**
	 * Basic Configuration class for GCC
	 * 
	 * @param apiUrl   API URL e.g. https://xxx-dev.translations.com
	 * @param userName User Name
	 * @param password Password
	 */
	public GCConfig(String apiUrl, String userName, String password) {
		this();
		this.apiUrl = apiUrl;
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * Basic Configuration class for GCC
	 * 
	 * @param apiUrl API URL e.g. https://xxx-dev.translations.com
	 * @param apiKey API Key 
	 */
	public GCConfig(String apiUrl, String apiKey) {
		this();
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	/**
	 * Basic Configuration class for GCC
	 * 
	 * @param apiUrl       API URL e.g. https://xxx-dev.translations.com
	 * @param userName     User Name
	 * @param password     Password
	 * @param connectorKey connector key
	 */
	public GCConfig(String apiUrl, String userName, String password, String connectorKey) {
		this(apiUrl, userName, password);
		this.connectorKey = connectorKey;
	}

	/**
	 * Basic Configuration class for GCC
	 * 
	 * @param apiUrl       API URL e.g. https://xxx-dev.translations.com
	 * @param userName     User Name
	 * @param password     Password
	 * @param connectorKey connector key
	 * @param userAgent    User Agent
	 */
	public GCConfig(String apiUrl, String userName, String password, String connectorKey, String userAgent) {
		this(apiUrl, userName, password, connectorKey);
		this.userAgent = userAgent;
	}

	/**
	 * Basic Configuration class for GCC
	 * 
	 * @param apiUrl        API URL e.g. https://xxx-dev.translations.com
	 * @param userName      User Name
	 * @param password      Password
	 * @param connectorKey  connector key
	 * @param userAgent     User Agent
	 * @param customHeaders customHeaders
	 */
	public GCConfig(String apiUrl, String userName, String password, String connectorKey, String userAgent,
			String apiKey, Map<String, String> customHeaders) {
		this(apiUrl, userName, password, connectorKey, userAgent);
		this.apiKey = apiKey;
		this.customHeaders.putAll(customHeaders);
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getBearerToken() {
		return bearerToken;
	}

	public void setBearerToken(String bearerToken) {
		this.bearerToken = bearerToken;
	}

	public String getConnectorKey() {
		return connectorKey;
	}

	public void setConnectorKey(String connectorKey) {
		this.connectorKey = connectorKey;
	}

	public GCProxyConfig getProxyConfig() {
		return proxyConfig;
	}

	public void setProxyConfig(GCProxyConfig proxyConfig) {
		this.proxyConfig = proxyConfig;
	}

	public Map<String, String> getCustomHeaders() {
		return customHeaders;
	}

	public void setCustomHeaders(Map<String, String> customHeaders) {
		this.customHeaders = customHeaders;
	}

	public static Builder builder() {
		return new Builder();
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getTrustStorePath() {
		return trustStorePath;
	}

	public void setTrustStorePath(String trustStorePath) {
		this.trustStorePath = trustStorePath;
	}

	public String getTrustStorePassword() {
		return trustStorePassword;
	}

	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

	public static class Builder {

		private String apiUrl;
		private String userName;
		private String password;
		private String connectorKey;
		private String userAgent;
		private String apiKey;
		private Map<String, String> customHeaders = new HashMap<>();

		private Builder() {
		}

		public Builder apiUrl(String apiUrl) {
			this.apiUrl = apiUrl;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder connectorKey(String connectorKey) {
			this.connectorKey = connectorKey;
			return this;
		}

		public Builder userAgent(String userAgent) {
			this.userAgent = userAgent;
			return this;
		}
		
		public Builder apiKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		public Builder customHeader(String name, String value) {
			customHeaders.put(name, value);
			return this;
		}

		public Builder customHeaders(Map<String, String> headers) {
			customHeaders.putAll(headers);
			return this;
		}

		public GCConfig build() {
			return new GCConfig(apiUrl, userName, password, connectorKey, userAgent, apiKey, customHeaders);
		}

	}

}
