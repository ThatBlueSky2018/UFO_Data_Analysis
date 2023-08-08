package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("stream_data")
public class StreamData {
    private Integer id;
    private String dateTime;
    private String city;
    private String state;
    private String country;
    private String shape;
    private String images;
}
