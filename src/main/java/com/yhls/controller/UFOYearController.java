package com.yhls.controller;


import com.yhls.pojo.ResponseResult;
import com.yhls.service.UFOYearService;
import com.yhls.utils.StatisticData;
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
public class UFOYearController {

    @Autowired
    private UFOYearService ufoYearService;

    @GetMapping("/year")
    public ResponseResult getData() {
        log.info("获取UFO年份统计信息");
        StatisticData<Integer,Integer> statisticData=ufoYearService.getData();
        return ResponseResult.success(statisticData);
    }
}
