package com.yhls.controller;


import com.yhls.pojo.ResponseResult;
import com.yhls.service.StreamDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api/ufo")
public class StreamDataController {
    @Autowired
    private StreamDataService streamDataService;

    @GetMapping("/hasImageCount")
    public ResponseResult hasImageCount() {
        log.info("获取流式数据中有照片的数据的数量");
        Integer count=streamDataService.hasImageCount();
        return ResponseResult.success(count);
    }

    @GetMapping("/noImageCount")
    public ResponseResult noImageCount() {
        log.info("获取流式数据中没有照片的数据的数量");
        Integer count=streamDataService.noImageCount();
        return ResponseResult.success(count);
    }
}
