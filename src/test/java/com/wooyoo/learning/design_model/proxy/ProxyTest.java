package com.wooyoo.learning.design_model.proxy;


import com.alibaba.fastjson.JSON;
import com.wooyoo.learning.proxyPractice.UserCommon;
import com.wooyoo.learning.proxyPractice.impl.DbUser;
import com.wooyoo.learning.proxyPractice.impl.MyBeanFactory;
import com.wooyoo.learning.proxyPractice.impl.StaticProxyUser;
import org.junit.Test;



public class ProxyTest {

    @Test
    public void testProxy(){

        StaticProxyUser staticProxyUser = new StaticProxyUser(new DbUser());
        staticProxyUser.addUser();
        staticProxyUser.deleteUser();
    }


    @Test
    public void testJdkProxy(){

        UserCommon userCommon = MyBeanFactory.createUserCommon();
        userCommon.addUser();
        userCommon.deleteUser();

    }

    @Test
    public void testCglibProxy(){

        UserCommon cglibUserCommon = MyBeanFactory.createCglibUserCommon();
        cglibUserCommon.addUser();
        cglibUserCommon.deleteUser();



    }




}
