package org.gs4tr.gcc.restclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.ResponseData;
import org.gs4tr.gcc.restclient.request.GCLoginRequest;
import org.gs4tr.gcc.restclient.request.GCRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIUtils {

    public static final String LOGIN = "start_session";
    public static final String FILE_TYPES = "connector/config/file_types";
    public static final String REQUEST_LOCALES = "connector/config/locales";
    public static final String REQUEST_FILE_TYPES = "connector/config/file_types";
    public static final String REQUEST_JOB_OPTIONS = "connector/config/job_options";
    public static final String REQUEST_FILE_UPLOAD = "file/upload";
    public static final String REQUEST_FILE_CONTEXT_UPLOAD = "file/context/upload";
    public static final String REQUEST_TASK_LIST = "task/list";
    public static final String REQUEST_TASK_CONFIRM_DELIVERY = "task/confirm_delivery";
    public static final String REQUEST_TASK_UNSUBMITTED = "file/unsubmitted";
    public static final String DOWNLOAD_TASK = "task/download";
    public static final String REQUEST_JOB_LIST = "job/list";
    public static final String REQUEST_JOB_LIST_LOCALE = "locale_job/list";
    public static final String REQUEST_JOB_SUBMIT_FILES = "job/submit/files";
    public static final String REQUEST_JOB_SUBMIT_NODES = "job/submit/nodes";
    public static final String REQUEST_JOB_WORDCOUNT = "job/wordcount";

    public static GCResponse login(GCConfig config)
    {
	try{
	    ObjectMapper mapper = new ObjectMapper();
	    URL url = new URL(config.getApiUrl() + LOGIN);
	    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	    connection.setDoOutput(true);
	    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), Charset.forName("UTF-8"));
	    out.write(mapper.writeValueAsString(new GCLoginRequest(config.getUserName(), config.getPassword(), config.getUserAgent())));
	    out.close();

	    String response = null;
	    if (connection.getResponseCode() > 299) {
		response = StringUtils.toString(connection.getErrorStream());
		if (connection.getResponseCode() > 499) {
		    if (connection.getResponseCode() == 503) {
			throw new IllegalStateException("Service Temporarily Unavailable");
		    } else {
			throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode());
		    }
		}
	    } else {
		response = StringUtils.toString(connection.getInputStream());
	    }

	    GCResponse responseObj = mapper.readValue(response, GCResponse.class);
	    if (responseObj.getStatus() == null || !responseObj.getStatus().equals(200)) {
		throw new IllegalStateException(responseObj.getMessage());
	    }

	    return responseObj;
	} catch (IOException e) {
	    throw new IllegalStateException("Error sending request. " + e.getMessage());
	}
    }
    
    public static GCResponse doRequest(GCConfig config, String request, GCRequest gcrequest) {
	try {
	    ObjectMapper mapper = new ObjectMapper();
	    URL url = new URL(config.getApiUrl() + request);
	    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("client_secret_key", config.getClientSecretKey());
	    connection.setRequestProperty("Authorization", "Bearer " + config.getBearerToken());
	    connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	    connection.setDoOutput(true);
	    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), Charset.forName("UTF-8"));
	    out.write(mapper.writeValueAsString(gcrequest));
	    out.close();

	    String response = null;
	    if (connection.getResponseCode() > 299) {
		response = StringUtils.toString(connection.getErrorStream());
		if (connection.getResponseCode() > 499) {
		    if (connection.getResponseCode() == 503) {
			throw new IllegalStateException("Service Temporarily Unavailable");
		    } else {
			throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode());
		    }
		}
	    } else {
		response = StringUtils.toString(connection.getInputStream());
	    }

	    GCResponse responseObj = mapper.readValue(response, GCResponse.class);
	    if (responseObj.getStatus() == null || !responseObj.getStatus().equals(200)) {
		if(responseObj.getStatus().equals(404) && request.endsWith("list")){
		    responseObj.setResponseData(new ResponseData());
	            responseObj.getResponseData().setCurrentPageNumber(0);
	            responseObj.getResponseData().setTotalRecordsCount(0);
	            responseObj.getResponseData().setTotalResultPagesCount(0);
	            responseObj.getResponseData().setTasksList(null);
	            responseObj.getResponseData().setJobsList(null);
	            responseObj.getResponseData().setFilesList(null);
		} else {
		    throw new IllegalStateException(responseObj.getMessage());
		}
	    }

	    return responseObj;
	} catch (IOException e) {
	    throw new IllegalStateException("Error sending request. " + e.getMessage());
	}
    }

    public static GCResponse doRequestWithParameters(GCConfig config, String request, Map<String, Object> parameters) {

	MultipartUtility multipart = null;
	try {
	    multipart = new MultipartUtility(config.getApiUrl() + request, config);

	    Map<String, Object> m2 = new HashMap<String, Object>();
	    if (parameters != null) {
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
		    String key = entry.getKey();
		    if ("connector_id".equals(key)) {
			continue;
		    }
		    if (key.equals("preview_file") || key.equals("file")) {
			m2.put(key, entry.getValue());
		    } else {
			multipart.addFormField(key, "" + entry.getValue());
		    }

		}
	    }

	    for (Map.Entry<String, Object> entry : m2.entrySet()) {
		if (parameters.containsKey("name")) {
		    multipart.addFilePart(entry.getKey(), (byte[]) entry.getValue(), "" + parameters.get("name"));
		}
	    }

	    HttpsURLConnection connection = multipart.finish();

	    String response = null;
	    if (connection.getResponseCode() > 299) {
		response = StringUtils.toString(connection.getErrorStream());
		if (connection.getResponseCode() > 499) {
		    if (connection.getResponseCode() == 503) {
			throw new IllegalStateException("Service Temporarily Unavailable");
		    } else {
			throw new IllegalStateException("Server returned HTTP code " + connection.getResponseCode());
		    }
		}
	    } else {
		response = StringUtils.toString(connection.getInputStream());
	    }

	    ObjectMapper mapper = new ObjectMapper();
	    GCResponse responseObj = mapper.readValue(response, GCResponse.class);

	    if (responseObj.getStatus() == null || !responseObj.getStatus().equals(200)) {
		throw new IllegalStateException(responseObj.getMessage());
	    }

	    return responseObj;
	} catch (IOException e) {
	    throw new IllegalStateException("Error sending request: " + e.getMessage());
	}
    }

    public static InputStream doDownload(GCConfig config, String downloadRequest, GCRequest gcrequest)
	    throws IOException {
	ObjectMapper mapper = new ObjectMapper();
	URL url = new URL(config.getApiUrl() + downloadRequest);
	HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	connection.setRequestMethod("POST");
	connection.setRequestProperty("client_secret_key", config.getClientSecretKey());
	connection.setRequestProperty("Authorization", "Bearer " + config.getBearerToken());
	connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
	connection.setDoOutput(true);
	OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), Charset.forName("UTF-8"));
	out.write(mapper.writeValueAsString(gcrequest));
	out.close();

	return connection.getInputStream();
    }
}
