package com.shortener.linkshorten;

public class ShortenRequest {

    private String toShorten;

    public ShortenRequest(String toShorten) {
        this.toShorten = toShorten;
    }

    public ShortenRequest() {
    }

    public String getToShorten() {
        return toShorten;
    }

    public void setToShorten(String toShorten) {
        this.toShorten = toShorten;
    }
}
