package com.wooyoo.learning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;


@Component
public class RedisUtil implements ApplicationContextAware, InitializingBean {



     static RedisTemplate redisTemplate;
    static ApplicationContext applicationContext;

    @Autowired
    public RedisUtil( RedisTemplate redisTemplate){

        this.redisTemplate = redisTemplate;
    }
    public static boolean set(Object key, Object value,Long expireSecond){
        redisTemplate.opsForValue().set(key,value,expireSecond);
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        //this.applicationContext = applicationContext;

        //this.redisTemplate = applicationContext.getBean( RedisTemplate.class);
    }





}
