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
    private GCProxyConfig proxyConfig;
    private Map<String, String> customHeaders = new HashMap<>();

    private String bearerToken;
    
    private Logger logger;
    
    public GCConfig() {
	logger = Logger.getLogger(GCExchange.class.getName());
	logger.setLevel(Level.OFF);
    }

    public GCConfig(String apiUrl, String userName, String password) {
	this();
	this.apiUrl = apiUrl;
	this.userName = userName;
	this.password = password;
    }

    public GCConfig(String apiUrl, String userName, String password, String connectorKey) {
	this(apiUrl, userName, password);
	this.connectorKey = connectorKey;
    }

    public GCConfig(String apiUrl, String userName, String password, String connectorKey, String userAgent) {
	this(apiUrl, userName, password, connectorKey);
	this.userAgent = userAgent;
    }

    public GCConfig(String apiUrl, String userName, String password, String connectorKey, String userAgent,
	    Map<String, String> customHeaders) {
	this(apiUrl, userName, password, connectorKey, userAgent);
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

    public static class Builder {

	private String apiUrl;
	private String userName;
	private String password;
	private String connectorKey;
	private String userAgent;
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

	public Builder customHeader(String name, String value) {
	    customHeaders.put(name, value);
	    return this;
	}

	public Builder customHeaders(Map<String, String> headers) {
	    customHeaders.putAll(headers);
	    return this;
	}

	public GCConfig build() {
	    return new GCConfig(apiUrl, userName, password, connectorKey, userAgent, customHeaders);
	}

    }

}
