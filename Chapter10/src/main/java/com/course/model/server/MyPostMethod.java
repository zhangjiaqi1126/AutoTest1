package com.course.model.server;

import com.course.model.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value ="/",description = "这是我的post的请求")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来装我们cookies信息的
    private static Cookie cookie;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    //@RequestParam中的属性required=""true表示这个参数是必传的
    public String login(HttpServletResponse response, @RequestParam(value = "username",required = true) String username,
                                                      @RequestParam(value = "password",required = true) String password){
        if (username.equals("zhangjiaqi") && password.equals("123456")){
            //添加cookies信息
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功";
        }
        return  "用户名或密码错误";
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value="获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for (Cookie c :cookies){
            if (c.getName().equals("login")&& c.getValue().equals("true")
                                    && u.getUsername().equals("zhangjiaqi")
                                    && u.getPassword().equals("123456")){
                User user = new User();
                user.setName("lisi");
                user.setAge("23");
                user.setSex("man");
                return user.toString();
            }
        }

        return  "参数不合法";
    }
}
