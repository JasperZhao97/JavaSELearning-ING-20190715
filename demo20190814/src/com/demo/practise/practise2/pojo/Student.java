package com.demo.practise.practise2.pojo;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月14日  20:17:38
 */
public class Student {

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
    public String toString() {
        return "学生证号：" + stuNumber  +
                ", 学生姓名：" + name ;
    }
}
