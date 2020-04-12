package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentFeignServiceFallback.java
 * @Description TODO
 * @createTime 2020年04月11日 18:44:00
 */
@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {
    @Override
    public String getTimeout() {
        return "独有的配置类处理";
    }
}
