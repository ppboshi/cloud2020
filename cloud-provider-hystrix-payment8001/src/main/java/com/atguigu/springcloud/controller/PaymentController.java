package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentController.java
 * @Description TODO
 * @createTime 2020年04月10日 16:54:00
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/ok/{id}")
    public String getOK(@PathVariable Integer id){
        return paymentService.paymentInfo_OK(id);
    }
    @GetMapping("/timeout")
    public String getTimeout(){
        return paymentService.paymentInfo_Timeout();
    }
}
