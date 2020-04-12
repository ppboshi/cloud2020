package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentService.java
 * @Description TODO
 * @createTime 2020年03月29日 15:03:00
 */

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
    String getTimeout();
}
