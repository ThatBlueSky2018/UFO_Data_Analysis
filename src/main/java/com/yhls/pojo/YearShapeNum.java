package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("year_shape_dynamic_sorting_2")
public class YearShapeNum {
    private Integer yearinfo;
    private String shape;
    private Integer count;
}