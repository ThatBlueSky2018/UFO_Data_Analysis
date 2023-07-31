package com.yhls.service.impl;

import com.yhls.mapper.UFOSeasonMapper;
import com.yhls.service.UFOSeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UFOSeasonServiceImpl implements UFOSeasonService {

    @Autowired
    private UFOSeasonMapper ufoSeasonMapper;
}
