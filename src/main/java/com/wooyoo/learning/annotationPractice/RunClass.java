package com.wooyoo.learning.annotationPractice;

public class RunClass {

    public static void run(@InitSalary(salary = 12) int salary){
        System.out.println("salary==>"+salary);

    }
}
