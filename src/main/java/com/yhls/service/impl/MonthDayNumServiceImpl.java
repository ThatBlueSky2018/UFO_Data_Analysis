package com.yhls.service.impl;

import com.yhls.mapper.MonthDayNumMapper;
import com.yhls.pojo.MonthDayNum;
import com.yhls.service.MonthDayNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonthDayNumServiceImpl implements MonthDayNumService {

    @Autowired
    private MonthDayNumMapper monthDayNumMapper;


    @Override
    public List<Integer> getData() {
        List<MonthDayNum> records=monthDayNumMapper.selectList(null);
        List<Integer> data=new ArrayList<>();
        for(MonthDayNum record:records) {
            data.add(record.getNum());
        }
        return data;
    }
}
