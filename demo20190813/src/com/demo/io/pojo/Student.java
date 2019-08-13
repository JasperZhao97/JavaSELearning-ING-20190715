package com.demo.io.pojo;

import java.io.Serializable;

/**
 * 学生类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  16:16:34
 */
public class Student implements Serializable {

    private String name;
    private String gender;
    private Integer age;
    private Class aClass;

    public Student() {
    }

    public Student(String name, String gender, Integer age, Class aClass) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.aClass = aClass;
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

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
