package com.yhls.service.impl;

import com.yhls.mapper.UFOShapeMapper;
import com.yhls.pojo.UFOShape;
import com.yhls.service.UFOShapeService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOShapeServiceImpl implements UFOShapeService {

    @Autowired
    private UFOShapeMapper ufoShapeMapper;

    @Override
    public StatisticData<String, Integer> getData() {
        List<UFOShape> records=ufoShapeMapper.selectList(null);
        List<String> shape=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(UFOShape record:records) {
            shape.add(record.getShape());
            count.add(record.getCount());
        }
        StatisticData<String,Integer> statisticData=new StatisticData<>();
        statisticData.setIndependentVariable(shape);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
