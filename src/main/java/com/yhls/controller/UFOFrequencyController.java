package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.UFOFrequencyService;
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
public class UFOFrequencyController {

    @Autowired
    private UFOFrequencyService ufoFrequencyService;

    @GetMapping("/frequency")
    public ResponseResult getData() {
        log.info("获取UFO按照州出现频率相关信息");
        StatisticData<String,Integer> statisticData =ufoFrequencyService.getData();
        return ResponseResult.success(statisticData);
    }
}
