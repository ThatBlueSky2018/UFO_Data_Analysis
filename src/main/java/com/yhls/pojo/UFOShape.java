package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 最常出现形状统计的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ufo_shape")
public class UFOShape {
    private String shape;
    private Integer count;
}
