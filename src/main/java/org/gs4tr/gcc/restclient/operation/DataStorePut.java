package org.gs4tr.gcc.restclient.operation;

import java.util.HashMap;
import java.util.Map;

import org.gs4tr.gcc.restclient.GCConfig;
import org.gs4tr.gcc.restclient.dto.GCResponse;
import org.gs4tr.gcc.restclient.dto.MessageResponse;
import org.gs4tr.gcc.restclient.request.GCRequest;
import org.gs4tr.gcc.restclient.util.MapAsPropertiesSerizalizer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DataStorePut extends GCOperation {

	private DataStorePutRequest request;

	public DataStorePut(GCConfig config, Map<String, Object> keyValues) {
		super(config);
		this.request = new DataStorePutRequest(keyValues, config);
	}

	private static final String REQUEST_URL = "datastore/key";
	private static final String REQUEST_METHOD = "PUT";

	@Override
	public String getRequestMethod() {
		return REQUEST_METHOD;
	}

	@Override
	protected String getApiUrl() {
		return REQUEST_URL;
	}

	@Override
	public GCRequest getRequestObject() {
		return null;
	}
	
	@Override
	public String getRequestJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(request.getKeyValues());
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Error writing json from "+request.getKeyValues(), e);
		}
	}

	public static class DataStorePutRequest extends GCRequest {
		@JsonSerialize(using = MapAsPropertiesSerizalizer.class)
		private Map<String, Object> keyValues;

		public DataStorePutRequest(Map<String, Object> keyValues, GCConfig config) {
			this.keyValues = new HashMap<String, Object>();
			this.keyValues.putAll(keyValues);
			this.keyValues.put("connector_key", config.getConnectorKey());
		}

		public Map<String, Object> getKeyValues() {
			return keyValues;
		}

		public void setKeyValues(Map<String, Object> keyValues) {
			this.keyValues = keyValues;
		}
		
	}

	@Override
	public Class<? extends GCResponse> getResponseClass() {
		return MessageResponse.class;
	}

}
