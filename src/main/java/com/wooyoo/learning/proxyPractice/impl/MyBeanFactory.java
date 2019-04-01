package com.wooyoo.learning.proxyPractice.impl;

import com.wooyoo.learning.annotationPractice.UserMapperExtTest;
import com.wooyoo.learning.annotationPractice.Workers;
import com.wooyoo.learning.model.domain.User;
import com.wooyoo.learning.model.mapper.UserMapper;
import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;
import com.wooyoo.learning.proxyPractice.UserCommon;
import javafx.scene.input.DataFormat;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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


    public static UserMapperExt createUserMapperExt() {



        UserMapperExt  userMapperExt =(UserMapperExt)Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), new Class[]{UserMapperExt.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String replaceResult = null;
                if(method.isAnnotationPresent(Select.class)){
                    Select annotation = method.getAnnotation(Select.class);
                    for(String s:annotation.value()){
                        //  System.out.println("annotation.value=====>"+ s);
                        String usernameSql = null;

                        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                        for(Annotation [] parameterAnnotation : parameterAnnotations ){

                           // replaceResult =getReplaceResult(parameterAnnotation,args,s,0);
                           /* for(int i = 0; i<parameterAnnotation.length;i++){
                                replaceResult=  s.replace("#{"+((Param)parameterAnnotation[i]).value()+"}",(String)args[i]);

                            }*/
                            for(Annotation annotation1 :parameterAnnotation){
                                Param param = (Param) annotation1;

                                replaceResult =getReplaceResult(param,args,s,0);
                             /*   if( "username".equals(param.value())){
                                    usernameSql = s.replace("#{"+param.value()+"}", (String)args[0]);

                                }
                                if("password".equals(param.value())){
                                    replaceResult=  usernameSql.replace("#{"+param.value()+"}",(String)args[1]);
                                }*/
                                //  System.out.println( "param.value=====>"+ param.value());
                            }
                        }
                        // System.out.println( "username.password.value,=====>"+ username  + "   "+password);
                    }
                    System.out.println("replace=====>"+ replaceResult);
                }
                //Object obj = method.invoke(userMapperExtImp, args);
                Class clazz = method.getReturnType();
                return clazz.newInstance();
            }
        });
        return  userMapperExt;


    }


    public static String getReplaceResult( Param param,Object[] args,String sql,int i){


        if(i<args.length){
            if( sql.contains(param.value())){
                String  resultSql = sql.replace("#{"+param.value()+"}", (String)args[i]);
                i++;
                getReplaceResult(param,args,resultSql,i);
                return  resultSql;
            }
        }

            return  sql;

    }


    public static UserMapperExt createUserMapperExt2() {

        return (UserMapperExt)Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), new Class[]{UserMapperExt.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                if ( method.getName().equals("login")){
                    // 重载
                    return new User();
                }

                if ( method.getName().equals("getUserId")){
                    return 1;
                }

                return null;
            }
        });
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
