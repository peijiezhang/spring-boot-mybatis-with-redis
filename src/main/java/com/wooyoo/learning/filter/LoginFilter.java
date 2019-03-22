package com.wooyoo.learning.filter;

import com.alibaba.druid.util.StringUtils;
import com.wooyoo.learning.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebFilter("/*")
@Slf4j
public class LoginFilter implements Filter {


    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("LoginFilter ==> init method: init");

        filterConfig.getInitParameter("");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
/*

        System.out.println("getRequestURL=====>"+httpServletRequest.getRequestURL());
        System.out.println("getParameterMap=====>"+httpServletRequest.getParameterMap());
        System.out.println( "getContextPath=====>"+httpServletRequest.getContextPath());
        System.out.println("getQueryString====>"+httpServletRequest.getQueryString());
*/

    /*    httpServletRequest.getRequestURL();
        // ?a=b&a=c
        // a [b,c]
        httpServletRequest.getParameterMap();


        // 拿到tomcat的contextPath
        httpServletRequest.getContextPath();

        // a=b&a=c
        httpServletRequest.getQueryString();

        httpServletRequest.getHeaderNames();
        httpServletRequest.getHeader("Content-Type");*/

        if ( httpServletRequest.getRequestURI().contains("login")){

            filterChain.doFilter( servletRequest,servletResponse);
            return;
        }




        boolean authOk = false;
        try{

            if(httpServletRequest.getCookies()==null){
                //httpServletResponse.sendRedirect("Login");
                //http://localhost:9999/filetree/Login
                //http://localhost:9999/Login
                httpServletResponse.sendRedirect("http://localhost:8888/#/Login");

            }else{

                Cookie[] cookies = httpServletRequest.getCookies();
                for ( Cookie cookie:cookies  ) {
                    if (cookie.getName().equals("ut")) {
                        String value = cookie.getValue();
                        // 去redis中验
                        boolean hasRedisKey = redisTemplate.hasKey(value);

                        if (hasRedisKey) {
                            authOk = true;
                        } else {
                            authOk = false;

                        }
                    }

                    if (authOk) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        httpServletResponse.sendRedirect("http://localhost:8888/#/Login");
                    }
                }
            }

        }catch (Exception  e){
            throw new RuntimeException("cookie 值为空"+e.getMessage());

        }

    }

    @Override
    public void destroy() {

        log.info("LoginFilter ==> init method: destroy");
    }
}
