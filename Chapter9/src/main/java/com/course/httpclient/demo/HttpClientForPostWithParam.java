package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClientForPostWithParam {
    public static void main(String[] args) throws IOException {
        //声明一个post方法
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
        //声明一个client，用来执行post方法
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置参数
        JSONObject param = new JSONObject();
        param.put("scope","project");
        param.put("q","java");
        //设置请求头信息 设置header
        httpPost.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode()==200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }else{
            System.out.println("post访问失败");
        }
    }
}
