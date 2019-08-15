package com.demo.practise.practise12.pojo;

import java.io.Serializable;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 09:48:53
 */
public class Employee extends Person implements Serializable {

    private String id;
    private String name;

    public Employee() {
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
