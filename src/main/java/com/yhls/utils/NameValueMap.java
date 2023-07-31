package com.yhls.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 键值对映射中间工具类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameValueMap<K,V> {
    private K name;
    private V value;
}
