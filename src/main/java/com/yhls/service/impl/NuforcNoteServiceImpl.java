package com.yhls.service.impl;

import com.yhls.mapper.NuforcNoteMapper;
import com.yhls.pojo.NuforcNote;
import com.yhls.service.NuforcNoteService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NuforcNoteServiceImpl implements NuforcNoteService {

    @Autowired
    private NuforcNoteMapper nuforcNoteMapper;

    @Override
    public StatisticData<String, Integer> getData() {
        List<NuforcNote> records=nuforcNoteMapper.selectList(null);
        List<String> possibleSign=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(NuforcNote record:records) {
            possibleSign.add(record.getPossibleSign());
            count.add(record.getCount());
        }
        StatisticData<String,Integer> statisticData =new StatisticData<>();
        statisticData.setIndependentVariable(possibleSign);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
