package com.wooyoo.learning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;


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

    public static void main(String[] args) throws MalformedURLException {


        URL url = new URL("http://cypse.swift.oudianyun.com/read/readTree?a=b#/soaZkTreeList?nsCode=ones2.5-prod&envCode=branch&type=1&zkNamespace=%2F");

        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());

        System.out.println(url.getPath());

        System.out.println(url.getQuery());

        System.out.println(url.getRef());





    }





}
