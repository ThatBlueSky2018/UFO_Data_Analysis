package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * UFO描述词云实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ufo_words")
public class UFOWords {
    private String word;
    private Integer count;
}
