package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentController.java
 * @Description TODO
 * @createTime 2020年03月29日 15:09:00
 */
@RestController
@Slf4j
@RequestMapping("/payment")
@Api(tags = "paymen控制器")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result > 0)
        {
            return new CommonResult(200,"插入数据库成功哈哈哈:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败略略略",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果"+paymentById);
        return paymentById==null?new CommonResult(400,"无数据",null):new CommonResult(200,"c成功"+serverPort,paymentById);
    }
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"-"+instance.getHost()+"-"+instance.getPort()+"-"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/timeout")
    public String timeOutTest(){

        return paymentService.getTimeout();
    }
    @GetMapping("/lb")
    public String getLB(){
        return serverPort;
    }


}
