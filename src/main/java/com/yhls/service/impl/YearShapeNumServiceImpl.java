package com.yhls.service.impl;

import com.yhls.mapper.YearShapeNumMapper;
import com.yhls.pojo.YearShapeNum;
import com.yhls.service.YearShapeNumService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YearShapeNumServiceImpl implements YearShapeNumService {
    @Autowired
    private YearShapeNumMapper yearShapeNumMapper;

    public List<List<Object>> getData() {
        List<YearShapeNum> records = this.yearShapeNumMapper.selectList(null);
        List<List<Object>> data = new ArrayList<>();
        List<Object> head = new ArrayList<>();
        head.add("Count");
        head.add("FillUp1");
        head.add("FillUp2");
        head.add("Shape");
        head.add("Year");
        data.add(head);
        for (YearShapeNum record : records) {
            List<Object> metadata = new ArrayList<>();
            metadata.add(record.getNum());
            metadata.add("");
            metadata.add("");
            metadata.add(record.getShape());
            metadata.add(record.getYearinfo());
            data.add(metadata);
        }
        return data;
    }
}
