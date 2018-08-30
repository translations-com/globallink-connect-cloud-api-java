package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State extends GCBasicModel {
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("state_number")
    private Long stateNumber;
    @JsonProperty("last_update_date")
    private Date lastUpdateDate;

    public State() {

    }

    public String getStateName() {
	return stateName;
    }

    public void setStateName(String stateName) {
	this.stateName = stateName;
    }

    public Long getStateNumber() {
	return stateNumber;
    }

    public void setStateNumber(Long stateNumber) {
	this.stateNumber = stateNumber;
    }

    public Date getLastUpdateDate() {
	return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
    }

}
