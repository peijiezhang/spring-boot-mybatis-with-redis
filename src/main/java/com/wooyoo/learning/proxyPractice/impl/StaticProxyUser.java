package com.wooyoo.learning.proxyPractice.impl;

import com.wooyoo.learning.proxyPractice.UserCommon;

public class StaticProxyUser implements UserCommon {

    private DbUser daUser;
    public StaticProxyUser(DbUser daUser){
        this.daUser = daUser;
    }
    @Override
    public void addUser() {
        System.out.println("添加前的操作");
        daUser.addUser();
        System.out.println("添加后的操作");

    }

    @Override
    public void deleteUser() {
        System.out.println("删除前的操作");
        daUser.deleteUser();
        System.out.println("删除后的操作");
    }
}
