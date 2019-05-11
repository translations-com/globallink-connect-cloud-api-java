package org.gs4tr.gcc.restclient.util;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.model.GCFile;
import org.gs4tr.gcc.restclient.operation.Content;
import org.gs4tr.gcc.restclient.operation.Content.ContentResponse;
import org.gs4tr.gcc.restclient.operation.Content.ContentResponseData;
import org.gs4tr.gcc.restclient.operation.GCOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@PrepareForTest({ HttpUtils.class })
@RunWith(PowerMockRunner.class)
public class APIUtilsTest {

    private static final GCConfig TEST_CONFIG = getTestConfig();
    private static final int OK = 200;

    private HttpURLConnection mockConnection;

    @Before
    public void setUpMocks() throws IOException {
        mockSuccessfulConnection();

        PowerMockito.mockStatic(HttpUtils.class);
        PowerMockito.when(HttpUtils.openConnection(any(URL.class)))
                .thenReturn(mockConnection);
        PowerMockito.doCallRealMethod()
                .when(HttpUtils.class);
        HttpUtils.addHeaders(eq(mockConnection), anyMapOf(String.class, String.class));
    }

    @Test
    public void doRequest_givenOperationWithCustomHeaders_shouldSetCustomHeaders() throws IOException {
        APIUtils.doRequest(getOperationWithCustomHeaders());

        verifyCustomHeadersSet();
    }

    @Test
    public void doRequestWithParameters_givenOperationWithCustomHeaders_shouldSetCustomHeaders() throws IOException {
        APIUtils.doRequestWithParameters(getOperationWithCustomHeaders());

        verifyCustomHeadersSet();
    }

    @Test
    public void doDownload_givenOperationWithCustomHeaders_shouldSetCustomHeaders() throws IOException {
        APIUtils.doDownload(getOperationWithCustomHeaders());

        verifyCustomHeadersSet();
    }

    private void mockSuccessfulConnection() throws IOException {
        mockConnection = mock(HttpsURLConnection.class);
        when(mockConnection.getResponseCode()).thenReturn(OK);
        when(mockConnection.getOutputStream()).thenReturn(new ByteArrayOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        byte[] connectionResponse = mapper.writeValueAsString(getOperationResponse())
                .getBytes();
        when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream(connectionResponse));
    }

    private void verifyCustomHeadersSet() {
        for (Map.Entry<String, String> header : TEST_CONFIG.getCustomHeaders().entrySet()) {
            verify(mockConnection).setRequestProperty(header.getKey(), header.getValue());
        }
    }

    private GCOperation getOperationWithCustomHeaders() {
        return new Content(TEST_CONFIG);
    }

    private GCResponse getOperationResponse() {
        ContentResponse response = new ContentResponse();
        response.setStatus(OK);
        ContentResponseData data = new ContentResponseData();
        data.setResponseData(new ArrayList<GCFile>());
        response.setResponseData(data);
        return response;
    }

    private static GCConfig getTestConfig() {
        return GCConfig.builder()
                .apiUrl("https://test.api.url/v0")
                .connectorKey("test-connector")
                .password("pass1234")
                .userAgent("test-agent")
                .userName("test-user")
                .customHeaders(getTestHeaders())
                .build();
    }

    private static Map<String, String> getTestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic abcd1234");
        headers.put("Accept", "application/json");
        headers.put("Custom-Value", "testing");
        return headers;
    }

}
