package org.gs4tr.gcc.restclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status extends GCBasicModel {
    @JsonProperty("state_name")
    private String statusName;
    @JsonProperty("state_number")
    private Long statusNumber;
    @JsonProperty("last_update_date")
    private Date lastUpdateDate;

    public Status() {

    }

    public String getStatusName() {
	return statusName;
    }

    public void setStatusName(String statusName) {
	this.statusName = statusName;
    }

    public Long getStatusNumber() {
	return statusNumber;
    }

    public void setStatusNumber(Long statusNumber) {
	this.statusNumber = statusNumber;
    }

    public Date getLastUpdateDate() {
	return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
    }

}
