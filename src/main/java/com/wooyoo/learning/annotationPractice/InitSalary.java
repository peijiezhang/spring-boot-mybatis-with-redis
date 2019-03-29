package com.wooyoo.learning.annotationPractice;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.PARAMETER,ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface InitSalary {

    public int salary() default 0;

}
