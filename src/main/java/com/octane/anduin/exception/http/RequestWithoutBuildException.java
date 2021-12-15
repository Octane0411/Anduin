package com.octane.anduin.exception.http;

public class RequestWithoutBuildException extends RequestException {

    public RequestWithoutBuildException() {
        super("Request without build", null);
    }
}
