package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.YearShapeNumService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class YearShapeNumController {
    @Autowired
    private YearShapeNumService yearShapeNumService;

    @GetMapping({"/yearShapeNum"})
    public ResponseResult getData() {
        log.info("获取UFO三种目击形状随年份的变化关系表");
        List<List<Object>> data = this.yearShapeNumService.getData();
        return ResponseResult.success(data);
    }
}