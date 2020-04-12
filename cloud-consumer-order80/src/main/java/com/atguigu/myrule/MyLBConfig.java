package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyLBConfig.java
 * @Description TODO
 * @createTime 2020年04月02日 16:45:00
 */
@Configuration
public class MyLBConfig {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
