package org.gs4tr.gcc.restclient.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest({ URL.class, HttpUtils.class })
@RunWith(PowerMockRunner.class)
public class HttpUtilsTest {

    private static final Map<String, String> TEST_HEADERS = getTestHeaders();

    @Test
    public void openConnection_givenURL_shouldReturnOpenConnection() throws IOException {
        URL mockUrl = PowerMockito.mock(URL.class); // URL is a final class, requires PowerMock
        HttpURLConnection expected = mock(HttpURLConnection.class);
        PowerMockito.when(mockUrl.openConnection())
                .thenReturn(expected);

        HttpURLConnection connection = HttpUtils.openConnection(mockUrl);

        assertEquals("Unknown connection returned by 'openConnection'", expected, connection);
    }

    @Test
    public void addHeaders_givenMapOfHeaders_shouldSetConnectionHeaders() {
        HttpURLConnection mockHttpConnection = mock(HttpURLConnection.class);
        
        HttpUtils.addHeaders(mockHttpConnection, TEST_HEADERS);

        for (Map.Entry<String, String> header : TEST_HEADERS.entrySet()) {
            verify(mockHttpConnection).setRequestProperty(header.getKey(), header.getValue());
        }
    }

    private static Map<String, String> getTestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic abcd1234");
        headers.put("Accept", "application/json");
        return headers;
    }

}
