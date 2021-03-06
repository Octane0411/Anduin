package com.octane.anduin.http.request;

import com.alibaba.fastjson.JSON;
import com.octane.anduin.exception.http.RequestWithoutBuildException;
import com.octane.anduin.http.constants.CharSet;
import com.octane.anduin.http.core.HttpRequest;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Map;

public class HttpRequestPost extends HttpRequest {

    public Object getRequestBody() {
        return this.requestBody;
    }

    public HttpRequest setRequestBody(Object requestBody) {
        this.requestBody = new StringEntity(JSON.toJSONString(requestBody), CharSet.UTF_8);
        return this;
    }

    public HttpRequestPost() {
    }

    public HttpRequestPost(String url) {
        super(url);
    }

    public HttpRequestPost(String url, String contentType) {
        super(url, contentType);
    }

    public HttpRequestPost(String url, Map<String, Object> parameters, String contentType) {
        super(url, parameters, contentType);
    }

    @Override
    public CloseableHttpResponse doRequest() {
        if (!this.isBuild) {
            throw new RequestWithoutBuildException();
        }
        HttpPost httpPost = new HttpPost(this.url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setEntity(this.requestBody);
        try {
            // 由客户端执行(发送)Get请求
            response = this.httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
        } catch (ParseException | IOException e) {
            System.out.println("abnormal connection,check your network" + e.getMessage());
        }
        return response;
    }
}
