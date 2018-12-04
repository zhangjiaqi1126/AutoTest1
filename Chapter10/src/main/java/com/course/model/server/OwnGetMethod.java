package com.course.model.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@RestController
@Api
public class OwnGetMethod {
    @RequestMapping(value = "ajax/services/feed/load",method = RequestMethod.GET)
    @ApiOperation(value = "这是我自己写的接口",httpMethod ="GET" )
    public Map<String,String> getBrowserMessage(@RequestParam String q, @RequestParam String v){

        Map<String,String> myList = new HashMap<>();
        myList.put("responseData", "null");
        myList.put("responseStatus", "403");
        myList.put("responseDetails","This API is no longer available.");
        return myList;

    }
}
