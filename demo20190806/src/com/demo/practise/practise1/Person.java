package com.demo.practise.practise1;

/**
 * Person类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  20:18:11
 */
public class Person {

    private String name;
    private String gender;
    private Integer age;

    public Person() {
    }

    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
