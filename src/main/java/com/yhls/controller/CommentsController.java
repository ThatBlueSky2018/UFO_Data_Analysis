package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.CommentsService;
import com.yhls.utils.StatisticData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/comments")
    public ResponseResult getData() {
        log.info("获取目击者描述统计信息");
        StatisticData<String, Integer> statisticData = commentsService.getData();
        return ResponseResult.success(statisticData);
    }
}
