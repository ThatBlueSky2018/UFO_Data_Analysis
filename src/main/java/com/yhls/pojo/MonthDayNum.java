package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 统计UFO目击的日期情况
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("month_day_num")
public class MonthDayNum {
    private Integer monthinfo;
    private Integer dayinfo;
    private Integer num;
}
