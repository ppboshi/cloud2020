package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PaymentServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月10日 16:52:00
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池"+Thread.currentThread().getName()+"\tok";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout() {
         try {
             TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
        return "线程池"+Thread.currentThread().getName()+"\t超时";
    }
    public String paymentInfo_TimeoutHandler(){
        return Thread.currentThread().getName()+"兜底"+"\to(╥﹏╥)o";
    }
}
