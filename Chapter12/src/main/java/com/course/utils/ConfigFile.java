package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;
/**
 * 读取配置文件，定义getUrl方法，获取完整的测试地址
 * */
public class ConfigFile {

   private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);;
    //参数InterfaceName枚举类是为了不让用户随便传值，必须要与InterfancName中定义好的对应
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;
        //判断name是否等于枚举类中定义的值，如果是就获取application配置文件中与其对应的uri
        if(name == InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");

        }

        if(name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        if(name == InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }

        if(name == InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if(name == InterfaceName.ADDUSERINFO){
            uri = bundle.getString("addUser.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}
