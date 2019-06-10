package org.gs4tr.gcc.restclient.request;

import org.gs4tr.gcc.restclient.util.KeepAsJsonDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataStoreRequest extends GCRequest {

    @JsonProperty("datastore")
    @JsonDeserialize(using = KeepAsJsonDeserializer.class)
    private String dataStoreString;
    
    public DataStoreRequest() {
	
    }
    
    public DataStoreRequest(String dataStoreString){
	this.setDataStoreString(dataStoreString);
    }

    public String getDataStoreString() {
	return dataStoreString;
    }

    public void setDataStoreString(String dataStoreString) {
	this.dataStoreString = dataStoreString;
    }
    
}