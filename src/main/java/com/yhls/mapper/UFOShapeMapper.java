package com.yhls.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhls.pojo.UFOShape;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UFOShapeMapper extends BaseMapper<UFOShape> {
    @Select("select * from ufo_shape limit 8;")
    List<UFOShape> getTop8();
}
