package com.wooyoo.learning.annotationPractice;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.xml.crypto.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

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

    public static void testParam( Class<?>  clazz,String mthname){

        DataClass dataClass = new DataClass(23);
        Method[] declaredMethods = clazz.getDeclaredMethods();
        int result =0;
        for(Method method:declaredMethods){
          /*  method.getModifiers();
            System.out.println( "  method.getModifiers=====>"+  Modifier.toString( method.getModifiers()));*/
            if(method.getName().equals(mthname)){
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                for(Annotation[] parameter : parameterAnnotations){
                    for(Annotation annotation: parameter){
                        if(annotation instanceof InitSalary){
                            result = ((InitSalary) annotation).salary();
                            //result= dataClass.getSalary();
                        }
                    }
                }
            }
        }
        RunClass.run(result);

    }
    public static void testConstruct( Class<?>  clazz){

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor constructor :declaredConstructors){
            if(constructor.isAnnotationPresent(InitSalary.class)){
                Annotation annotation = constructor.getAnnotation(InitSalary.class);
                if(annotation instanceof InitSalary){
                    InitSalary initSalary = (InitSalary) annotation;
                    System.out.println("initSalary.salary()====>"+    initSalary.salary());
                }
            }
        }

    }


    public static void test( Class<?>  clazz){

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method :declaredMethods){

       /*     if(method.isAnnotationPresent(Select.class)){
                Select annotation = method.getAnnotation(Select.class);
                for(String s:annotation.value()){
                    System.out.println("annotation.value=====>"+ s);
                }

                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                for(Annotation [] parameterAnnotation : parameterAnnotations ){
                    for(Annotation annotation1 :parameterAnnotation){
                        Param param = (Param) annotation1;
                        System.out.println( "param.value=====>"+ param.value());
                    }
                }
            }*/
        }

    }

}
