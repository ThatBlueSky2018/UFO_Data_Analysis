package com.yhls.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 封装自变量+因变量工具类，作为响应的内容
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Target<I,D> {
    private List<I> independentVariable; //自变量
    private List<D> dependentVariable; //因变量
}
