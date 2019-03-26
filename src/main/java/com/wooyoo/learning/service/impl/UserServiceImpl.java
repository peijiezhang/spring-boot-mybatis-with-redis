package com.wooyoo.learning.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wooyoo.learning.dao.UserDao;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.service.UserService;
import com.wooyoo.learning.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Autowired
    RedisTemplate redisTemplate;

/*
    @Autowired
    private RedisTemplate<String, String> redisTemplate;*/



    @Override
    public boolean isLogin(User user, HttpServletResponse response) {

        boolean isLogin = userDao.isLogin(user);


        //redisTemplate.opsForValue().set("");
        String token = UUID.randomUUID().toString();
        String username = user.getUsername();
        String password = user.getPassword();



        if ( isLogin ){
            Cookie cookie = new Cookie("ut",token);
            response.addCookie(cookie);

       /*     Map<String, Object> properties = new HashMap<>();
            properties.put("username", user.getUsername());
            properties.put("password", user.getPassword());

            redisTemplate.opsForHash().putAll(token, properties);*/



            RedisUtil.set(token,JSONObject.toJSONString(user),30l);
        }
        return isLogin;
    }
}
