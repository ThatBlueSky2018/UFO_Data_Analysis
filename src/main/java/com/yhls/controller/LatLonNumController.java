package com.yhls.controller;

import com.yhls.pojo.ResponseResult;
import com.yhls.service.LatLonNumService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class LatLonNumController {

    @Autowired
    private LatLonNumService latLonNumService;

    @GetMapping({"/latLonNum"})
    public ResponseResult list() {
        log.info("获取经纬度分布数据");
        List<List<Object>> list = this.latLonNumService.list();
        return ResponseResult.success(list);
    }
}
