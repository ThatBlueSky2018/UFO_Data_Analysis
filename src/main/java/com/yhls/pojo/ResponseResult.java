package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一相应结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private Integer code;//响应码，1 代表成功; 0 代表失败
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据

    //增删改 成功响应
    public static ResponseResult success(){
        return new ResponseResult(1,"success",null);
    }
    //查询 成功响应
    public static ResponseResult success(Object data){
        return new ResponseResult(1,"success",data);
    }
    //失败响应
    public static ResponseResult error(String msg){
        return new ResponseResult(0,msg,null);
    }
}