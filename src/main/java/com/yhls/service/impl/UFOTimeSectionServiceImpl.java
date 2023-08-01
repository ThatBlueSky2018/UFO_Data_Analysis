package com.yhls.service.impl;

import com.yhls.mapper.UFOTimeSectionMapper;
import com.yhls.pojo.UFOTimeSection;
import com.yhls.service.UFOTimeSectionService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOTimeSectionServiceImpl implements UFOTimeSectionService{

    @Autowired
    private UFOTimeSectionMapper ufoTimeSectionMapper;

    private String timeSectionMapper(Integer timeEnd) {
        if(timeEnd==10) {
            return "10秒之内";
        } else if (timeEnd==30) {
            return "10秒~30秒";
        } else if (timeEnd==60) {
            return "30秒~1分钟";
        } else if (timeEnd==300) {
            return "1分钟~5分钟";
        } else if (timeEnd==600) {
            return "5分钟~10分钟";
        } else if (timeEnd==1800) {
            return "10分钟~30分钟";
        } else if (timeEnd==3600) {
            return "30分钟~1小时";
        } else if (timeEnd==86400) {
            return "1小时~1天";
        } else if (timeEnd==604800) {
            return "1天~7天";
        } else {
            return "超过7天";
        }
    }
    @Override
    public StatisticData<String, Integer> getData() {
        List<UFOTimeSection> records=ufoTimeSectionMapper.selectList(null);
        List<String> timeSection=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        StatisticData<String,Integer> statisticData=new StatisticData<>();
        for(UFOTimeSection record:records) {
            if(record.getTimeSectionEnd()==null) {
                if(record.getTimeSectionStart()==null) {
                    timeSection.add("不确定");
                    count.add(record.getCountSum());
                }
                else {
                    timeSection.add("超过7天");
                    count.add(record.getCountSum());
                }
            }
            else {
                timeSection.add(timeSectionMapper(record.getTimeSectionEnd()));
                count.add(record.getCountSum());
            }
        }
         statisticData.setIndependentVariable(timeSection);
         statisticData.setDependentVariable(count);
        return statisticData;
    }
}
