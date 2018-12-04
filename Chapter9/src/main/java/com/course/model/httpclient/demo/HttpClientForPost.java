package com.course.model.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;


public class HttpClientForPost {
   private String url;
   private ResourceBundle bundle;
   @BeforeTest
   public void beforeTest(){
       bundle = ResourceBundle.getBundle("application");
       url = bundle.getString("test.url");

    }
    @Test
    public void testPost() throws IOException {
        String uri = bundle.getString("test.post");
        String testUrl = this.url+uri;
        //声明一个post方法
        HttpPost httppost = new HttpPost(testUrl);
        //声明一个client对象，它用来执行post方法
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //伪装浏览器请求
        httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode()==200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }else {
            System.out.println("post请求访问失败");
        }
    }

}
