package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UFO出现时长区间分布实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFOTimeSection {
    private Integer timeSection;
    private Integer count;
}
