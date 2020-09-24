package org.gs4tr.gcc.restclient.request;

import java.util.List;

import org.gs4tr.gcc.restclient.model.HistoryItem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckHistoryRequest extends GCMultiConnectorRequest {

	@JsonProperty("source_locale")
	private String sourceLocale;
	@JsonProperty("target_locales")
	private List<String> targetLocales;
	@JsonProperty("content")
	private List<HistoryItem> items;

	public CheckHistoryRequest(String sourceLocale, List<String> targetLocales, List<HistoryItem> items) {
		this.sourceLocale = sourceLocale;
		this.targetLocales = targetLocales;
		this.items = items;
	}
}
