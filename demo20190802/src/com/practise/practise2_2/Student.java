package com.practise.practise2_2;

/**
 * 学生类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月05日 10:33:36
 */
public class Student {

    private String name; //姓名
    private String gender; //性别
    private int age; //年龄

    public Student() {
    }

    public Student(String name, String gender, int age) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
