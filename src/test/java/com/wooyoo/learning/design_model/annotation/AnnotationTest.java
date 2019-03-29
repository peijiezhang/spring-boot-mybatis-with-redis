package com.wooyoo.learning.design_model.annotation;

import com.wooyoo.learning.annotationPractice.DataClass;
import com.wooyoo.learning.annotationPractice.RunClass;
import com.wooyoo.learning.annotationPractice.Workers;
import com.wooyoo.learning.annotationPractice.WorkersFactory;
import com.wooyoo.learning.model.mapper.mapperExt.UserMapperExt;
import org.junit.Test;

public class AnnotationTest {


    @Test
    public void  annotationTest(){

    // WorkersFactory.create(Workers.class);
        //WorkersFactory.testParam(RunClass.class,"run");

       // WorkersFactory.testConstruct(DataClass.class);

        WorkersFactory.test(UserMapperExt.class);


    }



}
