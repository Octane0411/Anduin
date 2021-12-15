package com.octane.anduin.utils;

import java.util.Map;

/**
 * String utils
 * contains basic String operations
 * an easy e.g like: isEmpty()
 */
public class StringUtils {

    //空字符串
    private static final String NULLSTR = "";

    //下划线
    private static final char UNDERSCORE = '_';

    /**
     * 判断一个对象是否为空
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || NULLSTR.equals(str);
    }

    /**
     * 将参数加到原始url的后尾
     * @param url 原始url
     * @param parameters 参数
     * @return 处理后的url
     */
    public static String handleUrlParameter(String url, Map<String, Object> parameters) {
        //TODO 将参数添加到url尾部
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        //链式调用append拼接字符串
        parameters.forEach((k, v) -> stringBuilder.append(k).append("=").append(v).append("&"));
        //删除最后一个多余的'&'
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
