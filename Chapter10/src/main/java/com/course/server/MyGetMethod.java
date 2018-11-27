package com.course.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//这个注解是告诉application类的，我是需要被扫描的类
@RestController
public class MyGetMethod {
    //配置访问路径，并设置访问的方法为get
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String  getCookies(HttpServletResponse response){
        //HttpServerletRequest  装请求信息的类
        //HttpServerletResponse   装响应信息的类
        //创建一个cookie对象
        Cookie cookie = new Cookie("login","true");
        //添加cookie信息
        response.addCookie(cookie);
        return "获取cookies信息成功";
    }
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        //获取cookie，因为有多个cookie信息，所以添加到cookies数组里
        Cookie[] cookies = request.getCookies();
        //判空
        if (Objects.isNull(cookies)){
            return  "你必须带着cookies信息来";
        }
        for (Cookie cookie :cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }
        return "你必须带着cookis信息来";
    }

    /**
     * 需要参数才能访问的get请求
     * 第一种方式url:port/key=value&key=value
     * */
    @RequestMapping(value= "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){

        Map <String,Integer> myList = new HashMap<>();
        myList.put("鞋子",300);
        myList.put("衬衫",200);
        myList.put("外套",600);
        return  myList;

    }

    /**
     * 需要参数才能访问的get请求
     * 第2种方式url:port/get/with/param/{start}/{end}
     * */
    @RequestMapping(value= "/get/with/param/{start}/{end}")
    public Map<String,Integer> getMyList(@PathVariable Integer start,
                                       @PathVariable Integer end){

        Map <String,Integer> myList = new HashMap<>();
        myList.put("鞋子",300);
        myList.put("衬衫",200);
        myList.put("外套",600);
        return  myList;

    }
}
