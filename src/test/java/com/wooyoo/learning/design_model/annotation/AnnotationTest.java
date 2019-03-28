package com.wooyoo.learning.design_model.annotation;

import com.wooyoo.learning.annotationPractice.Workers;
import com.wooyoo.learning.annotationPractice.WorkersFactory;
import org.junit.Test;

public class AnnotationTest {


    @Test
    public void  annotationTest(){

     WorkersFactory.create(Workers.class);

    }
}
