package com.yhls.service.impl;

import com.yhls.mapper.YearStateNumMapper;
import com.yhls.pojo.YearStateNum;
import com.yhls.service.YearStateNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YearStateNumServiceImpl implements YearStateNumService {
    @Autowired
    private YearStateNumMapper yearStateNumMapper;

    private static final Map<String,String> map;

    static {
        map=new HashMap<>();
        map.put("CA","California");
        map.put("FL","Florida");
        map.put("WA","Washington");
        map.put("TX","Texas");
        map.put("NY","New York");
        map.put("PA","Pennsylvania");
        map.put("AZ","Arizona");
        map.put("OH","Ohio");
    }


    public List<List<Object>> getData() {
        List<YearStateNum> records = yearStateNumMapper.selectList(null);

        List<List<Object>> data = new ArrayList<>();
        List<Object> head = new ArrayList<>();
        head.add("Count");
        head.add("FillUp1");
        head.add("FillUp2");
        head.add("State");
        head.add("Year");
        data.add(head);
        for (YearStateNum record : records) {
            List<Object> metadata = new ArrayList<>();
            metadata.add(record.getNum());
            metadata.add("");
            metadata.add("");
            metadata.add(map.get(record.getState()));
            metadata.add(record.getYearinfo());
            data.add(metadata);
        }
        return data;
    }
}
