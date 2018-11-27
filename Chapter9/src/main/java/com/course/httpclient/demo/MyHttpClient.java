package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        //用来存放我们的结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //执行get方法的
        HttpClient client = new DefaultHttpClient();
        //接收返回值
        HttpResponse response = client.execute(get);
        //使用EntityUtils.toString方法将获取到的内容转换为字符串赋值给变量result
        //response.getEntity()方法是获取返回的所有内容
        result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
        System.out.println(result);

    }
}
