package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ufo_dynamic_sorting")
public class YearShapeNum {
    private Integer yearinfo;
    private String shape;
    private Integer num;
}