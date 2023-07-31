package com.yhls.service.impl;

import com.yhls.mapper.UFOTimeSectionMapper;
import com.yhls.pojo.UFOTimeSection;
import com.yhls.service.UFOTimeSectionService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UFOTimeSectionServiceImpl implements UFOTimeSectionService{

    @Autowired
    private UFOTimeSectionMapper ufoTimeSectionMapper;

    private String timeSectionMapper(Integer time) {
        if(time<10) {
            return "10秒之内";
        } else if (time<30) {
            return "10秒~30秒";
        } else if (time<60) {
            return "30秒~1分钟";
        } else if (time<300) {
            return "1分钟~5分钟";
        } else if (time<600) {
            return "5分钟~10分钟";
        } else if (time<1200) {
            return "10分钟~20分钟";
        } else {
            return "超过20分钟";
        }
    }
    @Override
    public StatisticData<String, Integer> getData() {
        List<UFOTimeSection> records=ufoTimeSectionMapper.selectList(null);
        List<String> timeSection=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        Map<String,Integer> timeSectionMap=new HashMap<>(); //统计时间区间信息的哈希表
        for(UFOTimeSection record:records) {
            if(record.getTimeSection()==null) {
                timeSectionMap.put("不确定",timeSectionMap.getOrDefault("不确定",0)+record.getCount());
            }
            else {
                timeSectionMap.put(timeSectionMapper(record.getTimeSection()),
                        timeSectionMap.getOrDefault(timeSectionMapper(record.getTimeSection()),0)+
                        record.getCount());
            }
        }
         for(Map.Entry<String,Integer> entry:timeSectionMap.entrySet()) {
             timeSection.add(entry.getKey());
             count.add(entry.getValue());
         }
        StatisticData<String,Integer> statisticData=new StatisticData<>();
         statisticData.setIndependentVariable(timeSection);
         statisticData.setDependentVariable(count);
        return statisticData;
    }
}
