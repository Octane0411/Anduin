package com.octane.anduin.exception.http;

import com.octane.anduin.exception.SuperException;

public class RequestException extends SuperException {
    public RequestException(String code, Object[] args) {
        super("HttpRequest", code, args, null);
    }
}
