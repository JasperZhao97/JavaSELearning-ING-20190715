package com.demo.io.pojo;

import java.io.Serializable;

/**
 * 学生类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月12日  17:03:18
 */
public class Student implements Serializable {

    private String name;
    private String gender;
    private String age;

    public Student() {
    }

    public Student(String name, String gender, String age) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
