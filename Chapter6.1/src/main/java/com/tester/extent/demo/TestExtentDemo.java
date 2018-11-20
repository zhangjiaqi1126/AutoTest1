package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestExtentDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals("aaa","bbb");
    }
    @Test
    public void test3(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test4(){
        Reporter.log("这是我们自己写的日志");
        throw new RuntimeException("这是我们自己抛出的异常");
    }
}
