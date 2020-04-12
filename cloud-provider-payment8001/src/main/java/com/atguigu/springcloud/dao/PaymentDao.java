package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentDao.java
 * @Description TODO
 * @createTime 2020年03月29日 14:47:00
 */
@Mapper
public interface PaymentDao {
     int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
