package com.yhls.controller;


import com.yhls.pojo.ResponseResult;
import com.yhls.service.GPSService;
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
public class GPSController {
    @Autowired
    private GPSService gpsService;

    @GetMapping("/gps")
    public ResponseResult GPSData() {
        log.info("获取GPS数据");
        List<Float> gpsData = gpsService.getGPS();
        return ResponseResult.success(gpsData);
    }
}
