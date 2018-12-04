package com.course.model.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpClientForGetWithParam {
    @Test
    public void testPost() throws URISyntaxException, IOException {
        //创建一个httpclient对象，用来执行post方法
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个uri对象
        URIBuilder uriBuilder = new URIBuilder("http://www.kuaidi100.com/query");
        uriBuilder.addParameter("type", "yuantong");
        uriBuilder.addParameter("postid", "11111111111");
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode()==200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }else{
            System.out.println("访问失败");
        }
    }
}
