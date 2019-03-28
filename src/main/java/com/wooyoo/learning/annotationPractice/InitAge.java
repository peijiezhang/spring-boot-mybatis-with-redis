package com.wooyoo.learning.annotationPractice;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface InitAge {

    public int age() default 0;


}
