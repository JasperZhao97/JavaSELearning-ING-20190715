package com.demo.annotation;

import java.util.Date;

/**
 * 职员类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月08日  15:23:25
 */
public class Employee {

    private String name;//姓名
    @DateAnnotation(value = "2008/08/08",pattern = "yyyy/MM/dd")
    private Date inTime;//入职时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
}
