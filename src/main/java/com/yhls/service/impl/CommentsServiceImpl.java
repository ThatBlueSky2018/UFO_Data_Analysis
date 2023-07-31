package com.yhls.service.impl;

import com.yhls.mapper.CommentsMapper;
import com.yhls.pojo.Comments;
import com.yhls.service.CommentsService;
import com.yhls.utils.StatisticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 单词数量区间的映射
     * @param wordCountSection 整数，表示单词映射区间
     * @return 对应的字符串描述
     */
    private String wordCountSectionMapper(int wordCountSection) {
        if (wordCountSection<=10) {
            return "少于10个词";
        } else if (wordCountSection<=15) {
            return "10~15个词";
        } else if (wordCountSection<=20) {
            return "15~20个词";
        } else if (wordCountSection<=25) {
            return "20~25个词";
        } else if (wordCountSection<=30) {
            return "25~30个词";
        } else {
            return "大于30个词";
        }
    }

    @Override
    public StatisticData<String, Integer> getData() {
        List<Comments> records=commentsMapper.selectList(null);
        List<String> wordCountSection = new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        for(Comments record:records) {
            wordCountSection.add(wordCountSectionMapper(record.getWordCountSection()));
            count.add(record.getCount());
        }
        StatisticData<String,Integer> statisticData =new StatisticData<>();
        statisticData.setIndependentVariable(wordCountSection);
        statisticData.setDependentVariable(count);
        return statisticData;
    }
}
