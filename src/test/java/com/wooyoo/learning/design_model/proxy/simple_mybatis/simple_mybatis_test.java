package com.wooyoo.learning.design_model.proxy.simple_mybatis;

import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;
import com.wooyoo.learning.proxyPractice.impl.MyBeanFactory;
import org.junit.Test;

public class simple_mybatis_test {


    @Test
    public void test(){

        UserMapperExt userMapperExt = MyBeanFactory.createUserMapperExt();
        userMapperExt.login("admin","123456");



    }
}
