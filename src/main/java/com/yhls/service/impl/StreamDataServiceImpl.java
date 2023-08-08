package com.yhls.service.impl;

import com.yhls.mapper.StreamDataMapper;
import com.yhls.service.StreamDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamDataServiceImpl implements StreamDataService {
    @Autowired
    private StreamDataMapper streamDataMapper;


    @Override
    public Integer hasImageCount() {
        return streamDataMapper.hasImageCount();
    }

    @Override
    public Integer noImageCount() {
        return streamDataMapper.noImageCount();
    }
}
