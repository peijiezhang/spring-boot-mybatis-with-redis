package com.wooyoo.learning.proxyPractice.impl;

import com.wooyoo.learning.proxyPractice.UserCommon;
import javafx.scene.input.DataFormat;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;


public class MyBeanFactory {

    public static UserCommon createUserCommon() {

       final  UserCommon userCommon = new DbUser();
       //返回指定接口的代理类的实例
        //*将方法调用分派到指定的调用
        //*处理程序。
       UserCommon getProxy = (UserCommon) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), userCommon.getClass().getInterfaces(), new InvocationHandler() {
           //每个代理实例都有一个关联的调用处理程序。
           //*当在代理实例上调用方法时，该方法
           //*调用被编码并发送到{@code invoke}
           //*调用处理程序的方法。
           // 处理代理实例上的方法调用并返回
           //*结果。此方法将在调用处理程序上调用
           //*在代理实例上调用该方法时
           //*联系在一起。
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行前");
                Object obj = method.invoke(userCommon, args);
                System.out.println("执行后");
                return obj;
            }
        });

        return getProxy;
    }

    public static UserCommon createCglibUserCommon(){

        final  UserCommon userCommon = new DbUser();
        //核心类
        Enhancer enhancer = new Enhancer();
        //确定父类
        enhancer.setSuperclass(UserCommon.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long time = new Date().getTime();
                System.out.println("执行前时间"+time);
                Object invoke = method.invoke(userCommon, objects);
                long time1 = new Date().getTime();
                System.out.println("执行后时间"+time1);
                long l = time1 - time;
                System.out.println("耗时"+l);
                return invoke;
            }
        });

        //创建代理对象
        UserCommon userCommon1 =(UserCommon) enhancer.create();

        return  userCommon1;

    }

}
