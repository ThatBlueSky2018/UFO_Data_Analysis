package com.yhls.service.impl;

import com.yhls.mapper.UFOYearMapper;
import com.yhls.pojo.UFOYear;
import com.yhls.service.UFOYearService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOYearServiceImpl implements UFOYearService {

    @Autowired
    private UFOYearMapper ufoYearMapper;

    @Override
    public StatisticData<Integer, Integer> getData() {
        List<UFOYear> records=ufoYearMapper.selectList(null);
        List<Integer> year=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(UFOYear record:records) {
            year.add(record.getYear());
            year.add(record.getCount());
        }
        StatisticData<Integer,Integer> statisticData=new StatisticData<>();
        statisticData.setIndependentVariable(year);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
