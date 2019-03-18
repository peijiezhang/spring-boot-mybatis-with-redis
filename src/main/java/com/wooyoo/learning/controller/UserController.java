package com.wooyoo.learning.controller;


import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@RestController
@RequestMapping("/link")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public boolean isLogin(@RequestBody User user, HttpServletResponse response){

        boolean isLogin = userService.isLogin(user,response);


        return isLogin;
    }


    @RequestMapping("/enterHome")
    public boolean enterHome(){


        return true;
    }
 /*  @RequestMapping("/login")
    public boolean login(HttpServletResponse response){
       response.addHeader("Access-Control-Allow-Origin", "*");
       response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        return false;
    }
*/



}
