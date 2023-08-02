package com.yhls.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("year_state_num_4")
public class YearStateNum {
    private Integer yearinfo;
    private String state;
    private Integer num;
}
