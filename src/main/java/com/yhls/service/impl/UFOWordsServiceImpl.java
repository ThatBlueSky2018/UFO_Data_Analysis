package com.yhls.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhls.mapper.UFOWordsMapper;
import com.yhls.pojo.UFOWords;
import com.yhls.service.UFOWordsService;
import com.yhls.utils.NameValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFOWordsServiceImpl implements UFOWordsService {

    @Autowired
    private UFOWordsMapper ufoWordsMapper;

    @Override
    public List<NameValueMap<String,Integer>> getData() {
        QueryWrapper<UFOWords> wrapper=new QueryWrapper<>();
        wrapper.last("limit 100");
        List<UFOWords> records=ufoWordsMapper.selectList(wrapper);
        List<NameValueMap<String,Integer>> data=new ArrayList<>();
        for(UFOWords record:records) {
            NameValueMap<String,Integer> nameValueMap=new NameValueMap<>();
            nameValueMap.setName(record.getWord());
            nameValueMap.setValue(record.getCount());
            data.add(nameValueMap);
        }
        return data;
    }
}
