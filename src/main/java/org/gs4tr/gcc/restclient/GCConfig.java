package org.gs4tr.gcc.restclient;

public class GCConfig {

    private String apiUrl;
    private String userName;
    private String password;
    private String clientSecretKey;
    private String userAgent;

    private String bearerToken;

    public GCConfig() {

    }

    public GCConfig(String apiUrl, String userName, String password, String clientSecretKey) {
	this.apiUrl = apiUrl;
	this.userName = userName;
	this.password = password;
	this.clientSecretKey = clientSecretKey;
    }

    public GCConfig(String apiUrl, String userName, String password, String clientSecretKey, String userAgent) {
	this(apiUrl, userName, password, clientSecretKey);
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

    public String getClientSecretKey() {
	return clientSecretKey;
    }

    public void setClientSecretKey(String clientSecretKey) {
	this.clientSecretKey = clientSecretKey;
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

}
