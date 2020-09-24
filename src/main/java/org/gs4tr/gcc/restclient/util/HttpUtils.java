package org.gs4tr.gcc.restclient.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.GCProxyConfig;

public class HttpUtils {

    public static HttpURLConnection openConnection(URL url, GCConfig config) throws IOException {
	Proxy proxy = getProxy(config);
	if (url.toString().startsWith("https")) {
	    if (proxy != null) {
		return (HttpsURLConnection) url.openConnection(proxy);
	    } else {
		return (HttpsURLConnection) url.openConnection();
	    }
	} else {
	    if (proxy != null) {
		return (HttpURLConnection) url.openConnection(proxy);
	    } else {
		return (HttpURLConnection) url.openConnection();
	    }
	}
    }

    public static void addHeaders(HttpURLConnection connection, Map<String, String> headers) {
	if (headers != null) {
	    for (Map.Entry<String, String> header : headers.entrySet()) {
		connection.setRequestProperty(header.getKey(), header.getValue());
	    }
	}
    }

    public static Proxy getProxy(GCConfig config) {

	if (config.getProxyConfig() != null) {
	    final GCProxyConfig proxyConfig = config.getProxyConfig();
	    if (proxyConfig.getProxyHost() != null) {
		Proxy proxy = new Proxy(proxyConfig.getProxyType(), new InetSocketAddress(proxyConfig.getProxyHost(),
			proxyConfig.getProxyPort() > 0 ? proxyConfig.getProxyPort() : 80));
		if (!StringUtils.isNullOrEmpty(proxyConfig.getProxyUser())
			&& !StringUtils.isNullOrEmpty(proxyConfig.getProxyPassword())) {
		    
		    System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
		    java.net.Authenticator.setDefault(new java.net.Authenticator() {
			public java.net.PasswordAuthentication getPasswordAuthentication() {
			    return new java.net.PasswordAuthentication(proxyConfig.getProxyUser(),
				    proxyConfig.getProxyPassword().toCharArray());
			}
		    });
		}
		return proxy;
	    } else {
		return null;
	    }
	} else {
	    return null;
	}

    }
}
