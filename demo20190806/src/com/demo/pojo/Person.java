package com.demo.pojo;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  15:20:00
 */
public class Person {

    private String name;
    private Object[] values = new Object[10];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return values[0].toString();
    }

    public void setGender(String gender) {
        values[0] = gender;
    }

    public Integer getAge() {
        return Integer.parseInt(values[1].toString());
    }

    public void setAge(Integer age) {
        values[1] =  age;
    }
}
