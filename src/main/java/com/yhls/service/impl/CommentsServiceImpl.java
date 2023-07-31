package com.yhls.service.impl;

import com.yhls.mapper.CommentsMapper;
import com.yhls.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentService {

    @Autowired
    private CommentsMapper commentsMapper;
}
