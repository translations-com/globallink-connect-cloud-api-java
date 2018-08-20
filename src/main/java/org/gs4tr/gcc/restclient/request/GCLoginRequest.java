package org.gs4tr.gcc.restclient.request;

public class GCLoginRequest extends GCRequest {
    private final String username;
    private final String password;
    private final String user_agent;

    public GCLoginRequest(String username, String password, String user_agent) {
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
