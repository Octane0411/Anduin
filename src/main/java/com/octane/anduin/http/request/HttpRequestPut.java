package com.octane.anduin.http.request;

import com.alibaba.fastjson.JSON;
import com.octane.anduin.exception.http.RequestWithoutBuildException;
import com.octane.anduin.http.constants.CharSet;
import com.octane.anduin.http.core.HttpRequest;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

public class HttpRequestPut extends HttpRequest {
    @Override
    public HttpRequest setRequestBody(Object requestBody) {
        this.requestBody = new StringEntity(JSON.toJSONString(requestBody), CharSet.UTF_8);
        return this;
    }

    @Override
    public CloseableHttpResponse doRequest() {
        if (!this.isBuild) {
            throw new RequestWithoutBuildException();
        }
        HttpPut httpPut = new HttpPut(this.url);
        httpPut.setHeader("Content-Type", "application/json;charset=utf8");
        httpPut.setEntity(this.requestBody);
        try {
            // 由客户端执行(发送)Get请求
            response = this.httpClient.execute(httpPut);
            // 从响应模型中获取响应实体
        } catch (ParseException | IOException e) {
            System.out.println("abnormal connection,check your network" + e.getMessage());
        }
        return response;
    }
}
