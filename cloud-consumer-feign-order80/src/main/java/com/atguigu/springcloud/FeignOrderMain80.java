package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FeignOrderMain80.java
 * @Description TODO
 * @createTime 2020年04月08日 18:04:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class,args);
    }
}
