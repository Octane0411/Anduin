package com.octane.anduin.exception.http;

import com.octane.anduin.exception.SuperException;

public class HttpMethodNotExistException extends RequestException {

    public HttpMethodNotExistException() {
        super("HttpMethod dose not exist", null);
    }
}
