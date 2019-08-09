package com.demo.annotation;

import java.lang.reflect.Field;

/**
 * 人员类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月08日  11:23:37
 */
@PersonDefaultAnnotation(userName = "张三",age = 8)
public class Person {

//    @PersonDefaultAnnotation(userName = "")//编译失败，不能注解属性
    private String userName;
    private String gender;
    private int age;

    public String getUsername() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
