package com.yhls.service.impl;

import com.yhls.mapper.UFOFrequencyMapper;
import com.yhls.pojo.UFOFrequency;
import com.yhls.service.UFOFrequencyService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOFrequencyServiceImpl implements UFOFrequencyService {

    @Autowired
    private UFOFrequencyMapper ufoFrequencyMapper;

    @Override
    public StatisticData<String, Integer> getData() {
        List<UFOFrequency> records=ufoFrequencyMapper.selectList(null);
        List<String> state=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(UFOFrequency record:records) {
            state.add(record.getState());
            count.add(record.getCount());
        }
        //可能需要进行映射处理？
        StatisticData<String,Integer> statisticData =new StatisticData<>();
        statisticData.setIndependentVariable(state);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
