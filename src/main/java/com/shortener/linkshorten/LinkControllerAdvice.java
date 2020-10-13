package com.shortener.linkshorten;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = {LinkController.class})
public class LinkControllerAdvice {
    @ResponseBody // This will be returned in the response body
    @ExceptionHandler(LinkNotFoundException.class) // It handles this specific exception
    @ResponseStatus(HttpStatus.NOT_FOUND) // And returns NOT_FOUND as the status
    String LinkNotFoundHandler(LinkNotFoundException ex) {
        return ex.getMessage();
    }
}
