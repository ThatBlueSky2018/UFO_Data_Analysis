package com.yhls.service.impl;

import com.yhls.mapper.UFOShapeMapper;
import com.yhls.service.UFOShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UFOShapeServiceImpl implements UFOShapeService {

    @Autowired
    private UFOShapeMapper ufoShapeMapper;
}
