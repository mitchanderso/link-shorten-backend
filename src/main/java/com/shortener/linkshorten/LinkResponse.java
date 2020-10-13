package com.shortener.linkshorten;

public class LinkResponse {
    private static final String DOMAIN = "http://short.mitanderson.com/";
    private String urlWithDomain;

    public LinkResponse(String urlWithDomain) {
        this.urlWithDomain = urlWithDomain;
    }

    public String getUrlWithDomain() {
        return DOMAIN + urlWithDomain;
    }
}
