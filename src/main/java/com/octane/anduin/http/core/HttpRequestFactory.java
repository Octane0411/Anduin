package com.octane.anduin.http.core;

import com.octane.anduin.exception.http.HttpMethodNotExistException;
import com.octane.anduin.http.constants.HttpMethod;
import com.octane.anduin.http.request.HttpRequestGet;
import com.octane.anduin.http.request.HttpRequestPost;

public class HttpRequestFactory {

    public static HttpRequest createHttpRequest(String httpMethod) {
        switch (httpMethod) {
            case HttpMethod.GET:
                return new HttpRequestGet();
            case HttpMethod.POST:
                return new HttpRequestPost();
            default:
                throw new HttpMethodNotExistException();
        }
    }
}
