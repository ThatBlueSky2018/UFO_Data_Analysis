package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.UFOWordsService;
import com.yhls.utils.StatisticData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class UFOWordsController {
    @Autowired
    private UFOWordsService ufoWordsService;

    @GetMapping("/words")
    public ResponseResult getData() {
        log.info("获取UFO描述词汇云图");
        StatisticData<String,Integer> statisticData=ufoWordsService.getData();
        return ResponseResult.success(statisticData);

    }
}
