package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderConsulController.java
 * @Description TODO
 * @createTime 2020年04月01日 15:10:00
 */
@RestController
@Slf4j
public class OrderConsulController {
    public static final String INVOKE_URL="http://cloud-service-payment";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/payment/consul")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return forObject;
    }
}
