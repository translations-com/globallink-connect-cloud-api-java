package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GCJobState {
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("last_update_date")
    private Date lastUpdateDate;

    public GCJobState() {

    }

    public String getStateName() {
	return stateName;
    }

    public void setStateName(String stateName) {
	this.stateName = stateName;
    }

    public Date getLastUpdateDate() {
	return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
    }

}
