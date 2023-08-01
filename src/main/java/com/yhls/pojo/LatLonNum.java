package com.yhls.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("lat_lon_num")
public class LatLonNum {
    private Float latitude;
    private Float longitude;
    private Integer num;
}

