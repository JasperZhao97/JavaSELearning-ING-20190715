package com.demo.practise.practise12.pojo;

import java.io.Serializable;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 09:25:34
 */
public class Person implements Serializable {

    private String id; //ID
    private String name; //姓名

    public Person() {
    }

    public Person(String id, String name) {
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

   /* @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode()==obj.hashCode();
    }*/
}
