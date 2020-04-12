package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CommonResult.java
 * @Description TODO
 * @createTime 2020年03月29日 14:43:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T    data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
