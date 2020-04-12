package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FeignController.java
 * @Description TODO
 * @createTime 2020年04月08日 18:18:00
 */
@RestController

@Slf4j
@DefaultProperties(defaultFallback = "GlobalFallbackHandler")
public class FeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/timeout")
//    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "10000")})
    @HystrixCommand
    public String timeOutTest(){
        return paymentFeignService.getTimeout();
    }
    public String timeOutHandler(){
        return "8001出错";
    }
    public String GlobalFallbackHandler(){
        return "全局处理";
    }
//    @GetMapping("/consumer/hello")
//    public String hello(){
//        return "hello";
//    }
}
