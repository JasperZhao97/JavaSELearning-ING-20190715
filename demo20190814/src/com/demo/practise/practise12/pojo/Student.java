package com.demo.practise.practise12.pojo;

import java.io.Serializable;

/**
 * 学生类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 09:47:32
 */
public class Student extends Person implements Serializable {

    private String id;
    private String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
