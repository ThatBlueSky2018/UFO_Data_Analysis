package com.yhls.service.impl;

import com.yhls.mapper.NuforcNoteMapper;
import com.yhls.service.NuforcNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NuforcNoteServiceImpl implements NuforcNoteService {

    @Autowired
    private NuforcNoteMapper nuforcNoteMapper;
}
