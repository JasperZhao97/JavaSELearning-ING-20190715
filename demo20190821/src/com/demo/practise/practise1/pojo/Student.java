package com.demo.practise.practise1.pojo;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  20:05:12
 */
public class Student implements Serializable {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
