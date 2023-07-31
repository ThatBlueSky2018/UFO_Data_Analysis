package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 按照季节统计的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UFOSeason {
    private LocalDateTime dateTime;
    private Integer count;
}
