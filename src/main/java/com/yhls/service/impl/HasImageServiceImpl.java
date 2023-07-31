package com.yhls.service.impl;

import com.yhls.mapper.HasImageMapper;
import com.yhls.pojo.HasImage;
import com.yhls.service.HasImageService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class HasImageServiceImpl implements HasImageService {

    @Autowired
    private HasImageMapper hasImageMapper;


    public StatisticData<Integer,Integer> getData() {
        List<HasImage> records=hasImageMapper.selectList(null);
        List<Integer> hasImage = new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(HasImage record:records) {
            hasImage.add(record.getHasImage());
            count.add(record.getCount());
        }
        StatisticData<Integer,Integer> statisticData =new StatisticData<>();
        statisticData.setIndependentVariable(hasImage);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
