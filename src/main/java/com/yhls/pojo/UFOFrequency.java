package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UFO按州区分的出现频率的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ufo_frequency")
public class UFOFrequency {
    private String state;
    private Integer count;
}
