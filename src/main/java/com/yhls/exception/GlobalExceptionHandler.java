package com.yhls.exception;

import com.yhls.pojo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult ex(Exception e) {
        e.printStackTrace();
        return ResponseResult.error("对不起，操作失败！");
    }
}