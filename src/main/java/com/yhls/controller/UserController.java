package com.yhls.controller;


import com.yhls.dto.LoginDto;
import com.yhls.dto.RegisterDto;
import com.yhls.pojo.ResponseResult;
import com.yhls.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册的接口
     * @param registerDto 封装注册相关信息
     * @return 注册成功之后的JWT令牌
     */
    @PostMapping("/register")
    public ResponseResult register (@RequestBody RegisterDto registerDto) {
        log.info("用户注册，邮箱:{}",registerDto.getEmail());
        ResponseEntity<?> data=userService.register(registerDto);
        if (data.getStatusCode()== HttpStatus.SEE_OTHER) {
            return ResponseResult.error(Objects.requireNonNull(data.getBody()).toString());
        }
        return  ResponseResult.success(data.getBody());
    }

    /**
     * 用户登录的接口
     * @param loginDto 封装登录相关信息
     * @return 登录成功返回的字符串
     */
    @PostMapping("/login")
    public ResponseResult authenticate(@RequestBody LoginDto loginDto) {
        log.info("用户登录，邮箱:{}",loginDto.getEmail());
        String data;
        try {
            data = userService.login(loginDto);
        }catch (AuthenticationException e) {
            log.warn("用户登录失败，邮箱:{}",loginDto.getEmail());
            return ResponseResult.error("用户名或密码错误!");
        }
        return  ResponseResult.success(data);
    }

}
