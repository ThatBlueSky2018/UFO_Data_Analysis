package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UFO按州区分的出现频率的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFOFrequency {
    private String state;
    private Integer count;
}
