package com.yhls.service.impl;

import com.yhls.mapper.UFOWordsMapper;
import com.yhls.pojo.UFOWords;
import com.yhls.service.UFOWordsService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOWordsServiceImpl implements UFOWordsService {

    @Autowired
    private UFOWordsMapper ufoWordsMapper;

    @Override
    public StatisticData<String, Integer> getData() {
        List<UFOWords> records=ufoWordsMapper.selectList(null);
        List<String> words=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(UFOWords record:records) {
            words.add(record.getWord());
            count.add(record.getCount());
        }
        StatisticData<String,Integer> statisticData=new StatisticData<>();
        statisticData.setIndependentVariable(words);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
