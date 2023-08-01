package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UFO出现时长区间分布实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ufo_time_section_2")
public class UFOTimeSection {
    private Integer timeSectionStart;
    private Integer timeSectionEnd;
    private Integer countSum;
}
