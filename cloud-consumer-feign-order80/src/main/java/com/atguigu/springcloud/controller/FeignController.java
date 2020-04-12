package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
public class FeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getEntityById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);

    }
    @GetMapping("/consumer/timeout")
    public String timeOutTest(){
        return paymentFeignService.timeOutTest();
    }
    @GetMapping("/consumer/hello")
    public String hello(){
        return "hello";
    }
}
