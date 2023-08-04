package com.yhls.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


// 注册时的数据转换对象
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto implements Serializable {
    String firstName ;
    String lastName ;
    String email;
    String password ;
}
