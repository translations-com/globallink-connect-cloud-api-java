package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryItem {

	@JsonProperty("unique_identifier")
	private String uid;
	@JsonProperty("file_type")
	private String type;

	public HistoryItem() {

	}

	public HistoryItem(String uid, String type) {
		super();
		this.uid = uid;
		this.type = type;
	}

}
