package com.yhls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yhls.mapper")
public class UfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UfoApplication.class, args);
    }

}
