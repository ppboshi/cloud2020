package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentService.java
 * @Description TODO
 * @createTime 2020年04月10日 16:50:00
 */

public interface PaymentService {
    String paymentInfo_OK(Integer id);
    String paymentInfo_Timeout();
}
