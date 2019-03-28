package com.wooyoo.learning.annotationPractice;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InitDescription {

    public String company() default  "";
    public String workStatus() default "";
}
