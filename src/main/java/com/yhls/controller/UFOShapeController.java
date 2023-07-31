package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.UFOShapeService;
import com.yhls.utils.StatisticData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class UFOShapeController {
    @Autowired
    private UFOShapeService ufoShapeService;

    @GetMapping("/shape")
    public ResponseResult getData() {
        log.info("获取UFO形状统计数据");
        StatisticData<String, Integer> statisticData = ufoShapeService.getData();
        return ResponseResult.success(statisticData);
    }
}
