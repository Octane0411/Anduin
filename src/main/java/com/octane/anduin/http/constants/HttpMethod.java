package com.octane.anduin.http.constants;

/**
 * HTTP method CRUD operations
 *
 * GET
 * GET方法请求一个指定资源的表示形式，使用GET的请求应该只被用于获取数据。
 * POST
 * POST方法用于将实体提交到指定的资源，通常导致在服务器上的状态变化或副作用。
 * PUT
 * PUT方法用请求有效载荷替换目标资源的所有当前表示
 * PATCH
 * PATCH方法用于对资源应用部分修改。。
 * DELETE
 * DELETE方法删除指定的资源。
 * ------不常用的方法---------
 * HEAD
 * HEAD方法请求一个与GET请求的响应相同的响应，但没有响应体。
 * CONNECT
 * CONNECT方法建立一个到由目标资源标识的服务器的隧道。
 * OPTIONS
 * OPTIONS方法用于描述目标资源的通信选项。
 * TRACE
 * TRACE方法沿着到目标资源的路径执行一个消息环回测试。
 *
 */
public class HttpMethod {

    public static final String GET = "GET";

    public static final String POST = "POST";

    public static final String PATCH = "PATCH";

    public static final String DELETE = "DELETE";

    public static final String PUT = "PUT";

    public static final String HEAD = "HEAD";

    public static final String CONNECT = "CONNECT";

    public static final String OPTIONS = "OPTIONS";

    public static final String TRACE = "TRACE";
}
