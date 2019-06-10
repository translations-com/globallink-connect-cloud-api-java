package org.gs4tr.gcc.restclient.util;

import static org.gs4tr.gcc.restclient.util.HttpUtils.addHeaders;
import static org.gs4tr.gcc.restclient.util.HttpUtils.openConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.gs4tr.gcc.restclient.GCConfig;

/**
 * This utility class provides an abstraction layer for sending multipart HTTP
 * POST requests to a web server.
 * 
 * @author www.codejava.net
 *
 */
public class MultipartUtility {
    private final String boundary;
    private static final String LINE_FEED = "\r\n";
    private HttpURLConnection httpConn;
    private String charset = "UTF-8";
    private OutputStream outputStream;
    private PrintWriter writer;

    public MultipartUtility(URL requestURL, GCConfig config) throws IOException {

	boundary = "===" + System.currentTimeMillis() + "===";

	httpConn = openConnection(requestURL, config);
	httpConn.setRequestMethod("POST");
	httpConn.setRequestProperty("connector_key", config.getConnectorKey());
	httpConn.setRequestProperty("Authorization", "Bearer " + config.getBearerToken());
	httpConn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	addHeaders(httpConn, config.getCustomHeaders());
	httpConn.setUseCaches(false);
	httpConn.setDoOutput(true); // indicates POST method
	httpConn.setDoInput(true);
	httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	outputStream = httpConn.getOutputStream();
	writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
    }

    public void addFormField(String name, String value) {
	writer.append("--" + boundary).append(LINE_FEED);
	writer.append("Content-Disposition: form-data; name=\"" + name + "\"").append(LINE_FEED);
	writer.append("Content-Type: text/plain; charset=" + charset).append(LINE_FEED);
	writer.append(LINE_FEED);
	writer.append(value).append(LINE_FEED);
	writer.flush();
    }

    public void addFilePart(String fieldName, byte[] uploadFile, String fileName) throws IOException {
	writer.append("--" + boundary).append(LINE_FEED);
	writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"")
		.append(LINE_FEED);
	writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
	writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
	writer.append(LINE_FEED);
	writer.flush();

	outputStream.write(uploadFile);
	outputStream.flush();

	writer.append(LINE_FEED);
	writer.flush();
    }

    public void addHeaderField(String name, String value) {
	writer.append(name + ": " + value).append(LINE_FEED);
	writer.flush();
    }

    public HttpURLConnection finish() throws IOException {

	writer.append(LINE_FEED).flush();
	writer.append("--" + boundary + "--").append(LINE_FEED);
	writer.close();

	return httpConn;
    }
}
