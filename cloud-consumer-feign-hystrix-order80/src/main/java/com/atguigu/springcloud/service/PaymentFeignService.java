package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.impl.PaymentFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentFeignService.java
 * @Description TODO
 * @createTime 2020年04月08日 18:07:00
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignServiceFallback.class)
public interface PaymentFeignService {
    @GetMapping("/payment/timeout")
    public String getTimeout();
}
