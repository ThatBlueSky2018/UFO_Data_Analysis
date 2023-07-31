package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 按照年份统计的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ufo_year")
public class UFOYear {
    private Integer year;
    private Integer count;
}
