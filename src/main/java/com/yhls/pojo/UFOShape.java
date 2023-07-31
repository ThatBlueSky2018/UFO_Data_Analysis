package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 最常出现形状统计的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFOShape {
    private String shape;
    private Integer count;
}
