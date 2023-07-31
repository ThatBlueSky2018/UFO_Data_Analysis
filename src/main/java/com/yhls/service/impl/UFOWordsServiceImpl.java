package com.yhls.service.impl;

import com.yhls.mapper.UFOSeasonMapper;
import com.yhls.mapper.UFOWordsMapper;
import com.yhls.service.UFOWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UFOWordsServiceImpl implements UFOWordsService {

    @Autowired
    private UFOWordsMapper ufoWordsMapper;
}
