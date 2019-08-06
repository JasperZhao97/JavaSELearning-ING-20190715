package com.demo.pojo;

/**
 * 学生类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  13:50:09
 */
public class Student {

    private String name;//姓名
    private String gender;//性别
    private Integer age;//年龄

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
