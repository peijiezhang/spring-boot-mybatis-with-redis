package com.wooyoo.learning.annotationPractice;


import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public  @interface InitName {

    public String name() default "";
    // public  int age() default 18;

}
