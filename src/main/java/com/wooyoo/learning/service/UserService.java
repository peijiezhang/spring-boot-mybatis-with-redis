package com.wooyoo.learning.service;


import com.wooyoo.learning.model.domain.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public boolean isLogin(User user, HttpServletResponse response);
}
