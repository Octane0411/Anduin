package com.octane.anduin.http.request;

import com.octane.anduin.exception.http.RequestWithoutBuildException;
import com.octane.anduin.http.core.HttpRequest;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Map;

public class HttpRequestGet extends HttpRequest {
    @Override
    public HttpRequest setRequestBody(Object requestBody) {
        return this;
    }

    public HttpRequestGet() {
    }

    public HttpRequestGet(String url) {
        super(url);
    }

    public HttpRequestGet(String url, String contentType) {
        super(url, contentType);
    }

    public HttpRequestGet(String url, Map<String, Object> parameters, String contentType) {
        super(url, parameters, contentType);
    }

    @Override
    public CloseableHttpResponse doRequest() {
        if (!this.isBuild) {
            throw new RequestWithoutBuildException();
        }
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        //CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(this.url);
        // 响应模型
        try {
            // 由客户端执行(发送)Get请求
            response = this.httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
        } catch (ParseException | IOException e) {
            System.out.println("abnormal connection,check your network" + e.getMessage());
        }
        return response;
    }

}
