package com.yhls.controller;


import com.yhls.pojo.ResponseResult;
import com.yhls.service.MonthDayNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/ufo")
public class MonthDayNumController {

    @Autowired
    private MonthDayNumService monthDayNumService;

    @GetMapping("/monthDayNum")
    public ResponseResult getData() {
        log.info("获取UFO目击日期分布");
        List<Integer> data = monthDayNumService.getData();
        return ResponseResult.success(data);
    }
}
