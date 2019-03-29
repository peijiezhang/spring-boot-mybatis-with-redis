package com.wooyoo.learning.annotationPractice;

import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;

public class UserMapperExtTest implements UserMapperExt {


    @Override
    public User login(@InitName(name = "小明") String username,@InitAge(age = 12) String password) {

        System.out.println(" =====");
        return null;
    }

    @Override
    public Integer getUserId(String username, String password) {
        return null;
    }
}
