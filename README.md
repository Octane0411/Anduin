# Anduin

## 简介

此项目是我在开发另一前后端分离应用时，为了便捷的对后端进行测试和修改，开发的HTTP请求组件。

组件基于

- apache httpclient:4.5.13
- fastjson:1.2.78

目标：提供轻量化，简单易用，功能齐全的http请求基础组件，以辅助后续的测试开发

优势：

- 轻量化
- 链式编程，简单易用

## 快速开始

1. maven引入依赖(目前并未上传到maven仓库，但jar包应该在近期上传至博客)

```xml
        <dependency>
            <groupId>com.octane</groupId>
            <artifactId>anduin</artifactId>
            <version>1.0</version>
        </dependency>
```

2. 从HttpRequestFactory中创造你想要的请求(HttpMethod中封装了常用的Http请求)

```java
HttpRequestGet request = (HttpRequestGet) HttpRequestFactory.createHttpRequest(HttpMethod.GET);
System.out.println(response);
String s = ResponseHandler.getResponseBody(response);
System.out.println(s);

```

3. 对请求进行自定义设置（支持链式），其中，在设置结束后请使用`build()`方法，否则将会抛出异常

```java
request.setUrl(url)//String url = "http://localhost:xxxx/xxx"
  .addParameter("pageNum", "1")
  .addParameter("pageSize", "2")
  .setRequestBody(new User("octane"));
  .build();
```

4. 执行请求并取得Response，此处的response类型为CloseableHttpResponse，此处略有遗憾，将在后面说明

```java
CloseableHttpResponse response = request.doRequest();
```

5. （可选）读出ResponseBody中的内容（目前只提供了String一种返回类型）

```java
String responseBody = ResponseHandler.getResponseBody(response);
```

6. （可选）关闭连接（对于CloseableHttpResponse）来说，在某些情况下关闭连接似乎是不必要的，相关内容可见https://blog.csdn.net/cg_Amaz1ng/article/details/104879658

```java
request.close();
```

## 遗憾

如果你仔细阅读了上面的代码，会很轻松的发现对于CloseableHttpResponse的封装并不完美，需要调用额外的ResponseHandler来处理ResponseBody，实际上我无能为力，在apache httpclient中，CloseableHttpResponse接口的默认唯一实现类是HttpResponseProxy，而这个类是私有的，无法从其他包访问，因此我无法使用它，也就不能明确response的类型，无法实现完全的链式调用。

```bash
'org.apache.http.impl.execchain.HttpResponseProxy' is not public in 'org.apache.http.impl.execchain'. Cannot be accessed from outside package
```

由于本人还在初学阶段，如果有什么方法可以解决这个问题，欢迎以一切方式指出

