package com.octane.anduin.http.request;

import com.octane.anduin.exception.http.RequestWithoutBuildException;
import com.octane.anduin.http.core.HttpRequest;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

public class HttpRequestDelete extends HttpRequest {

    @Override
    public HttpRequest setRequestBody(Object requestBody) {
        return this;
    }

    @Override
    public CloseableHttpResponse doRequest() {
        if (!this.isBuild) {
            throw new RequestWithoutBuildException();
        }
        HttpDelete HttpDelete = new HttpDelete(this.url);
        try {
            response = this.httpClient.execute(HttpDelete);
        } catch (ParseException | IOException e) {
            System.out.println("abnormal connection,check your network" + e.getMessage());
        }
        return response;
    }
}
