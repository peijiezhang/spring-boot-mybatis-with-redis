package com.wooyoo.learning.annotationPractice;

public class Workers {

    @InitName(name = "小花")
    private String name;

    @InitAge(age = 12)
    private int age;

    @InitDescription(company = "欧电云",workStatus = "工作三年了")
    private String description;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
