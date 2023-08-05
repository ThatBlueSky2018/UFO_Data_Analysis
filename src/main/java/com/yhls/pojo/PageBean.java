package com.yhls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 对分页查询进行封装的类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long count; //总记录数
    private List records; //数据列表
}
