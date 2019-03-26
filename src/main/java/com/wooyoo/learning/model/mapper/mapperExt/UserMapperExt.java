package com.wooyoo.learning.model.mapper.mapperExt;

import com.wooyoo.learning.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapperExt {

    @Select("select * from user where username =#{username}and password = #{password} ")
    User login(@Param("username") String username,@Param("password") String password);

    @Select("SELECT `user`.u_id FROM `user` WHERE username=#{username} and `password` =#{password} ")
    Integer getUserId(@Param("username") String username,@Param("password") String password);

}
