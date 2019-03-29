package com.wooyoo.learning.annotationPractice;

public class DataClass {

    private int salary;

    @InitSalary(salary = 44)
    public DataClass(int salary) {
        this.salary = salary;
        System.out.println(" this.salary====>"+salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
