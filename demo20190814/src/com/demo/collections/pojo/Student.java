package com.demo.collections.pojo;

import java.io.Serializable;

/**
 * 学生类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 16:46:07
 */
public class Student implements Serializable, Comparable<Student> {

    private String number; //学号
    private String name; //姓名

    public Student() {
    }

    public Student(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.number.compareTo(o.number);
    }
}
