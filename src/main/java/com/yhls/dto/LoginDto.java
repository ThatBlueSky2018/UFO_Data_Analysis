package com.yhls.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

//登录时的数据转换对象
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDto {
    private String email ;
    private String password ;
}
