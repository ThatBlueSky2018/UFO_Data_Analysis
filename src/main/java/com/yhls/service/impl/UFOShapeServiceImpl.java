package com.yhls.service.impl;

import com.yhls.mapper.UFOShapeMapper;
import com.yhls.pojo.UFOShape;
import com.yhls.service.UFOShapeService;
import com.yhls.utils.NameValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOShapeServiceImpl implements UFOShapeService {

    @Autowired
    private UFOShapeMapper ufoShapeMapper;

    @Override
    public List<NameValueMap<String,Integer>> getData() {
        List<UFOShape> records=ufoShapeMapper.getTop8();
        List<NameValueMap<String,Integer>> data=new ArrayList<>();
        for(UFOShape record:records) {
            NameValueMap<String,Integer> nameValueMap=new NameValueMap<>();
            nameValueMap.setName(record.getShape());
            nameValueMap.setValue(record.getCount());
            data.add(nameValueMap);
        }
        return data;
    }
}
