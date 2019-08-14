package com.demo.collections.pojo;

import java.io.Serializable;

/**
 * 职员类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 17:00:45
 */
public class Employee implements Serializable {

    private String name; //姓名
    private Integer salary; //工资

    public Employee() {
    }

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
