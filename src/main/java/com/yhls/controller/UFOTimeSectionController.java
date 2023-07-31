package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.UFOTimeSectionService;
import com.yhls.utils.StatisticData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class UFOTimeSectionController {

    @Autowired
    private UFOTimeSectionService ufoTimeSectionService;

    /**
     * 执行速度较慢，可能需要提前分析好保存在数据库中
     * @return data
     */
    @GetMapping("/timeSection")
    public ResponseResult getData() {
        log.info("获取UFO目击时间区间统计");
        StatisticData<String,Integer> statisticData=ufoTimeSectionService.getData();
        return ResponseResult.success(statisticData);
    }
}
