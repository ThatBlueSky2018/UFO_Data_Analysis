package com.yhls.service.impl;

import com.yhls.mapper.UFOYearMapper;
import com.yhls.service.UFOYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UFOYearServiceImpl implements UFOYearService {

    @Autowired
    private UFOYearMapper ufoYearMapper;
}
