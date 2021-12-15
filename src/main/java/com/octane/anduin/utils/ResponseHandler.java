package com.octane.anduin.utils;

import com.octane.anduin.http.constants.CharSet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ResponseHandler {

    public static String getResponseBody(CloseableHttpResponse response) throws IOException {
        return EntityUtils.toString(response.getEntity(), CharSet.UTF_8);
    }
}
