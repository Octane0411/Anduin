package com.octane.anduin.http.core;

import com.octane.anduin.http.constants.CharSet;
import com.octane.anduin.utils.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class HttpRequest {


    public static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);

    public String url;

    public Map<String, Object> parameters;

    public boolean isBuild;

    //默认编码
    public String contentType = "utf-8";

    public CloseableHttpClient httpClient = null;

    public CloseableHttpResponse response = null;

    public StringEntity requestBody;

    public abstract HttpRequest setRequestBody(Object requestBody);

    public HttpRequest() {
        this.isBuild = false;
    }

    public HttpRequest(String url) {
        this.isBuild = false;
        this.url = url;
    }

    public HttpRequest(String url, String contentType) {
        this.isBuild = false;
        this.url = url;
        this.contentType = contentType;
    }

    public HttpRequest(String url, Map<String, Object> parameters, String contentType) {
        this.isBuild = false;
        this.url = url;
        this.parameters = parameters;
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public HttpRequest setUrl(String url) {
        this.url = url;
        return this;
    }


    public HttpRequest addParameter(Map<String, Object> userParameters) {
        if (this.parameters == null) {
            this.parameters = new HashMap<>();
        }
        //lambda表达式遍历map并添加
        userParameters.forEach((k, v) -> this.parameters.put(k, v));
        return this;
    }

    public HttpRequest addParameter(String key, String value) {
        if (this.parameters == null) {
            this.parameters = new HashMap<>();
        }
        this.parameters.put(key, value);
        return this;
    }

    public Map<String, Object> getParameters() {
        return this.parameters;
    }


    public abstract CloseableHttpResponse doRequest();

    public String getResponseBody() throws IOException {
        return EntityUtils.toString(response.getEntity(), CharSet.UTF_8);
    }


    public HttpRequest build() {
        if (this.url == null) {
            throw new IllegalArgumentException("null url");
        }
        this.isBuild = true;
        if (parameters != null) {
            this.url = StringUtils.handleUrlParameter(url, parameters);
        }
        this.httpClient = HttpClientBuilder.create().build();
        return this;
    }

    public void close() throws IOException {
        try {
            // 释放资源
            if (httpClient != null) {
                httpClient.close();
            }
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
