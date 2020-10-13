package com.shortener.linkshorten;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(String link){
        super("Could not find link with value " + link);
    }
}
