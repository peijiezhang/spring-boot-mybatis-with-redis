package com.wooyoo.learning.jsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wooyoo.learning.jsonModel.User;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestJackson {


    @Test
    public void testJackson() throws ParseException, IOException {

        User user = new User();
        user.setName("zhangsan");
        user.setEmail("zhangsan@163.com");
        user.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
       // objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        String s = objectMapper.writeValueAsString(user);
        User user1 = objectMapper.readValue(s, User.class);


        System.out.println(s);
        System.out.println(user1);


    }



}
