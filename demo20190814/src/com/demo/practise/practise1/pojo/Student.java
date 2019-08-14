package com.demo.practise.practise1.pojo;

import java.util.HashSet;
import java.util.Objects;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月14日  19:18:19
 */
public class Student extends HashSet {

    private String stuNumber;
    private String name;

    public Student() {
    }

    public Student(String stuNumber, String name) {
        this.stuNumber = stuNumber;
        this.name = name;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return ((Student)o).getStuNumber().equals(stuNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stuNumber);
    }
}
