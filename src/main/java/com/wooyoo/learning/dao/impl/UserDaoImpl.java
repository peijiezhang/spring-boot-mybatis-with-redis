package com.wooyoo.learning.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.wooyoo.learning.dao.UserDao;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.domain.UserExample;
import com.wooyoo.learning.model.mapper.UserMapper;
import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;


@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapperExt userMapperExt;

    @Override
    public boolean isLogin(User user) {


        boolean login = true;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<User>list =  userMapper.selectByExample(userExample);

        if(list.size()==0){
            login = false;
            return login;
        }else {
            return login;

        }



    }
}
