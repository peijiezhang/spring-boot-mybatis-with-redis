package com.wooyoo.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@ServletComponentScan("com.wooyoo")
public class SpringBootMybatisWithRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisWithRedisApplication.class, args);
    }
}
