package org.gs4tr.gcc.restclient;

public class GCConfig {

    private String apiUrl;
    private String userName;
    private String password;
    private String connectorKey;
    private String userAgent;

    private String bearerToken;

    public GCConfig() {

    }

    public GCConfig(String apiUrl, String userName, String password) {
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

}
