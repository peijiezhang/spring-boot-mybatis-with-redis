package com.wooyoo.learning.annotationPractice;

import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;



public class UserMapperExtTest implements UserMapperExt {



    private  String username;
    private String password;

  /*  public UserMapperExtTest( String username, String password){

        this.password =  password;
        this.username = username;

    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User login( String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        return user;
    }

    @Override
    public Integer getUserId(String username, String password) {
        return null;
    }






}
