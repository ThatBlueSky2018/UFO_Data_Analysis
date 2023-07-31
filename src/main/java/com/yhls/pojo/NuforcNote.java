package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 可能误认UFO信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuforcNote {
    private String possibleSign;
    private Integer count;
}