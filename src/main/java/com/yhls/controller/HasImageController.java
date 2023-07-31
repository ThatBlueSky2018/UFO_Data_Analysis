package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.HasImageService;
import com.yhls.utils.Target;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HasImageController {

    @Autowired
    private HasImageService hasImageService;

    @GetMapping("/hasImage")
    public ResponseResult getData() {
        log.info("获取目击报告有无照片的相关数据");
        Target<Integer,Integer> data=hasImageService.list();
        return ResponseResult.success(data);
    }
}
