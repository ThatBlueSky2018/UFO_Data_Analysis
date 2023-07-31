package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * UFO描述词云实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFOWords {
    private String word;
    private Integer count;
}
