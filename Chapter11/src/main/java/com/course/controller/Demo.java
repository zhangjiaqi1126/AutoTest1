package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//Api和RequestMapping里的value要一致
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping(value= "v1")
@Log4j
public class Demo {
    //获取一个执行sql的对象
    @Autowired//启动即加载，demo启动的时候，对象template就被加载了
    private SqlSessionTemplate template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取到用户数")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }
    //新增数据insert into
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是insert into方法",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return  template.insert("addUser",user);
    }
    //update数据
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "这是我update的方法",httpMethod = "POST")
    public int updataUser(@RequestBody User user){
       return template.update("updateUser",user);
    }
    //delete数据
    @RequestMapping(value ="/deleUser",method = RequestMethod.GET)
    @ApiOperation(value = "这是我的删除接口",httpMethod = "GET")
    public int deleUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }
}
