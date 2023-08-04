package com.yhls.service;

import com.yhls.dto.LoginDto;
import com.yhls.dto.RegisterDto;
import com.yhls.pojo.Role;
import com.yhls.pojo.User;
import org.springframework.http.ResponseEntity;


public interface UserService {
    String login(LoginDto loginDto);
    ResponseEntity<?> register (RegisterDto registerDto);
    Role saveRole(Role role);

    User saverUser (User user) ;
}