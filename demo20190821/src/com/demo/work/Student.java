package com.demo.work;

import java.io.Serializable;

/**
 * 学生类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月22日 09:59:23
 */
public class Student implements Serializable {

    private String name;
    private transient String gender;
    private static Integer age;

    public Student() {
    }

    public Student(String name, String gender, Integer age) {
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
