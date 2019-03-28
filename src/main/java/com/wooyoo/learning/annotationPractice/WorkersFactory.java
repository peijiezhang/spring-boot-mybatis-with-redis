package com.wooyoo.learning.annotationPractice;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WorkersFactory {

    public static void create( Class<?>  clazz){

        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            if(field.isAnnotationPresent(InitName.class)){

                InitName annotation = field.getAnnotation(InitName.class);
                System.out.println("职工姓名====》"+ annotation.name());
            }else if(field.isAnnotationPresent(InitAge.class)){

                InitAge annotation = field.getAnnotation(InitAge.class);
                System.out.println("职工年龄====》"+ annotation.age());
            }else  if(field.isAnnotationPresent(InitDescription.class)){

                InitDescription annotation = field.getAnnotation(InitDescription.class);
                System.out.println("公司===》"+annotation.company()+"       "+"工作状态===》"+annotation.workStatus());
            }

        }

    }

}
