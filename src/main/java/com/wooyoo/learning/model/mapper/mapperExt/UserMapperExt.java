package com.wooyoo.learning.model.mapper.mapperExt;

import com.wooyoo.learning.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapperExt {

    @Select("select * from user where userName =#{username}and passWord = #{passWord} ")
    User login(@Param("user") String username);


}
