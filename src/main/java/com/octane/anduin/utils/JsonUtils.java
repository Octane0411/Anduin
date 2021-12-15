package com.octane.anduin.utils;

import com.alibaba.fastjson.JSON;
import com.octane.anduin.http.constants.CharSet;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public class JsonUtils {

    public static StringEntity toStringEntity(Object object) {
        return new StringEntity(JSON.toJSONString(object), CharSet.UTF_8);
    }
}
