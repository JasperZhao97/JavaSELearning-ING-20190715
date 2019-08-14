package com.demo.practise.practise12.pojo;

import java.io.Serializable;

/**
 * 职员类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 10:12:21
 */
public class Employee implements Serializable {

    private String name;
    private Company company;

    public Employee() {
    }

    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
