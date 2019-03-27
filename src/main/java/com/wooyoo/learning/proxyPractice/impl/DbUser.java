package com.wooyoo.learning.proxyPractice.impl;

import com.wooyoo.learning.proxyPractice.UserCommon;

public class DbUser implements UserCommon {
    @Override
    public void addUser() {
        System.out.println("添加用户操作");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户操作");
    }
}
