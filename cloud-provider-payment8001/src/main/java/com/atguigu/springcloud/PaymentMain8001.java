package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentMain8001.java
 * @Description TODO
 * @createTime 2020年03月28日 15:13:00
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication

public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
