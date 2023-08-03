package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.YearStateNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/ufo")
public class YearStateNumController {
    @Autowired
    private YearStateNumService yearStateNumService;

    @GetMapping({"/yearStateNum"})
    public ResponseResult getData() {
        log.info("获取各个州UFO目击事件数量随年份的变化关系表");
        List<List<Object>> data = this.yearStateNumService.getData();
        return ResponseResult.success(data);
    }
}