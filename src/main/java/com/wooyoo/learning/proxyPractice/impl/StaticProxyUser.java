package com.wooyoo.learning.proxyPractice.impl;

import com.wooyoo.learning.proxyPractice.UserCommon;

import java.util.Date;

public class StaticProxyUser implements UserCommon {

    private DbUser daUser;
    public StaticProxyUser(DbUser daUser){
        this.daUser = daUser;
    }
    @Override
    public void addUser() {
        long time = new Date().getTime();
        System.out.println("执行前时间"+time);
        daUser.addUser();
        long time1 = new Date().getTime();
        System.out.println("执行后时间"+time1);
        long l = time1 - time;
        System.out.println("耗时"+l);

    }

    @Override
    public void deleteUser() {
        System.out.println("删除前的操作");
        daUser.deleteUser();
        System.out.println("删除后的操作");
    }
}
