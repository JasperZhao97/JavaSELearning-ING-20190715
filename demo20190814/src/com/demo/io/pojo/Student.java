package com.demo.io.pojo;

import java.io.Serializable;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 10:59:02
 */
public class Student implements Serializable {

    private String name = "张山";
    private static String gender = "男";
    private transient Integer age = 21;

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
