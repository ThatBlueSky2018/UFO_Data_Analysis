package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 目击报告有无照片
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HasImage {
    private Integer hasImage;
    private Integer count;
}