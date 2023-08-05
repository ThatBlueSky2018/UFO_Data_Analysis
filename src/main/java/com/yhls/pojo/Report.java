package com.yhls.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("report")
public class Report {
    @TableId(type= IdType.AUTO)
    private Long id;

    private LocalDateTime datetime;
    private String city;
    private String state;
    private String country;
    private String shape;
    private int duration;
    private String summaryInfo;
    private Integer images;  //0表示没有,1表示有
    private Integer approved; //0表示未通过审核,1表示通过审核
}
