package com.demo.practise.practise12.pojo;

import java.io.Serializable;

/**
 * 公司类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 10:11:14
 */
public class Company implements Serializable {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
