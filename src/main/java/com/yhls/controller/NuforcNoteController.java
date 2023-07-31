package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.NuforcNoteService;
import com.yhls.utils.StatisticData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
public class NuforcNoteController {

    @Autowired
    private NuforcNoteService nuforcNoteService;

    @GetMapping("/nuforcNote")
    public ResponseResult getData() {
        log.info("获取可能误认UFO的信息统计");
        StatisticData<String,Integer> statisticData =nuforcNoteService.getData();
        return ResponseResult.success(statisticData);
    }
}
