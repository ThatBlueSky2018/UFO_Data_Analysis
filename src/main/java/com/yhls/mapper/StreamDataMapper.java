package com.yhls.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface StreamDataMapper {

    @Select("select count(*) from stream_data where images='Yes';")
    Integer hasImageCount();

    @Select("select count(*) from stream_data where images='No';")
    Integer noImageCount();
}
