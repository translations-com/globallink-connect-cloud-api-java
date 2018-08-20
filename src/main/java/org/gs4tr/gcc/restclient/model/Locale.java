package org.gs4tr.gcc.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Locale {

    @JsonProperty("locale")
    private String locale;
    @JsonProperty("locale_display_name")
    private String localeDisplayName;
    public Locale(){
	
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public String getLocaleDisplayName() {
        return localeDisplayName;
    }
    public void setLocaleDisplayName(String localeDisplayName) {
        this.localeDisplayName = localeDisplayName;
    }
    
}
