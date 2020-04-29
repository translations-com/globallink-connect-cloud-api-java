package org.gs4tr.gcc.restclient;

import java.net.Proxy;

public class GCProxyConfig {

	/**
	 * Proxy type. Defaults to HTTP
	 */
	private Proxy.Type proxyType = Proxy.Type.HTTP;

	/**
	 * Proxy server IP address or hostname
	 */
	private String proxyHost;
	/**
	 * [OPTIONAL] - Proxy user password
	 */
	private String proxyPassword;
	/**
	 * Proxy server port
	 */
	private int proxyPort;
	/**
	 * [OPTIONAL] - Proxy user
	 */
	private String proxyUser;

	/**
	 * Returns proxy server IP address or hostname
	 * 
	 * @return Proxy host
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * [OPTIONAL] - Returns proxy user password
	 * 
	 * @return Proxy password
	 */
	public String getProxyPassword() {
		return proxyPassword;
	}

	/**
	 * Returns proxy server port
	 * 
	 * @return Proxy port
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * [OPTIONAL] - Returns proxy user
	 * 
	 * @return Proxy user
	 */
	public String getProxyUser() {
		return proxyUser;
	}

	/**
	 * Proxy server IP address or hostname
	 * 
	 * @param proxyHost Proxy server IP address or hostname
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * [OPTIONAL] - Proxy server user password
	 * 
	 * @param proxyPassword Proxy server user password
	 */
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	/**
	 * Proxy server port
	 * 
	 * @param proxyPort Proxy server port
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * [OPTIONAL] - Proxy user
	 * 
	 * @param proxyUser Proxy server user
	 */
	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}

	/**
	 * [OPTIONAL] - Proxy type HTTP or HTTPS. Defaults to HTTP
	 * 
	 * @return proxyType Proxy server Type
	 */
	public Proxy.Type getProxyType() {
		return proxyType;
	}

	/**
	 * [OPTIONAL] - Proxy type HTTP or HTTPS. Defaults to HTTP
	 * 
	 * @param proxyType Proxy server Type
	 */
	public void setProxyType(Proxy.Type proxyType) {
		this.proxyType = proxyType;
	}
}
