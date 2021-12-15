package com.octane.anduin;

import com.octane.anduin.entity.Tag;
import com.octane.anduin.http.constants.CharSet;
import com.octane.anduin.http.constants.HttpMethod;
import com.octane.anduin.http.core.HttpRequestFactory;
import com.octane.anduin.http.request.HttpRequestGet;
import com.octane.anduin.http.request.HttpRequestPost;
import com.octane.anduin.utils.ResponseHandler;
import com.octane.anduin.utils.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class BasicTest {

    public static final String testUrl = "http://110.42.183.227:8080";
    @Test
    public void handleUrlParameterTest() {
        String url = "http://localhost:8080";
        HashMap<String, Object> map = new HashMap<>();
        map.put("param1", "value1");
        map.put("param2", "value2");
        map.put("param3", "value3");
        String s = StringUtils.handleUrlParameter(url, map);
        System.out.println(s);
    }

    @Test
    public void testConnection() throws IOException {
        //String url = "http://localhost:8080/health/alive";
        String url = testUrl + "/category";
        HttpRequestGet request = (HttpRequestGet) HttpRequestFactory.createHttpRequest(HttpMethod.GET);
        request.setUrl(url).addParameter("pageNum", "1").addParameter("pageSize", "2").build();

        CloseableHttpResponse response = request.doRequest();
        response.getEntity();
        System.out.println(response);
        String s = ResponseHandler.getResponseBody(response);
        System.out.println(s);
        request.close();
    }

    @Test
    public void testConnectionEasy() throws IOException {
        String url = testUrl + "/tag";
        HttpRequestPost request = (HttpRequestPost) HttpRequestFactory.createHttpRequest(HttpMethod.POST);
        request.setUrl(url).
                setRequestBody(new Tag("测试标签")).build();
        CloseableHttpResponse response = request.doRequest();
        //response = (MyHttpResponse) response;
        System.out.println(response);
        System.out.println(ResponseHandler.getResponseBody(response));
        request.close();
    }
}
