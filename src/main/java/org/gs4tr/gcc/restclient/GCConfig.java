package org.gs4tr.gcc.restclient;

import java.util.HashMap;
import java.util.Map;

public class GCConfig {

    private String apiUrl;
    private String userName;
    private String password;
    private String connectorKey;
    private String userAgent;
    private Map<String, String> customHeaders = new HashMap<>();

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

    public Map<String, String> getCustomHeaders() {
        return customHeaders;
    }

    public void addCustomHeader(String name, String value) {
        customHeaders.put(name, name);
    }

    public static Builder builder() {
        return new Builder();
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
