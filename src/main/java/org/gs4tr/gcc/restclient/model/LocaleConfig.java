package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocaleConfig extends GCBasicModel {

	@JsonProperty("locale_label")
	private String localeLabel;
	@JsonProperty("pd_locale")
	private String pdLocale;
	@JsonProperty("connector_locale")
	private String connectorLocale;
	@JsonProperty("is_source")
	private Boolean isSource;

	public LocaleConfig() {

	}

	public String getLocaleLabel() {
		return localeLabel;
	}

	public void setLocaleLabel(String localeLabel) {
		this.localeLabel = localeLabel;
	}

	public String getConnectorLocale() {
		return connectorLocale;
	}

	public void setConnectorLocale(String connectorLocale) {
		this.connectorLocale = connectorLocale;
	}

	public Boolean getIsSource() {
		return isSource;
	}

	public void setIsSource(Boolean isSource) {
		this.isSource = isSource;
	}

	public String getPdLocale() {
		return pdLocale;
	}

	public void setPdLocale(String pdLocale) {
		this.pdLocale = pdLocale;
	}

}
