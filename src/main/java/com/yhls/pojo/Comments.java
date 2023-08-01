package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目击者描述信息统计
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    private Integer wordsCountSection;
    private Integer count;
}