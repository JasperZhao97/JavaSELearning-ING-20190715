package com.demo.practise.pojo;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月12日  19:38:30
 */
public class Cat implements Serializable {

    private String Type;
    private String color;
    private String size;

    public Cat() {
    }

    public Cat(String type, String color, String size) {
        Type = type;
        this.color = color;
        this.size = size;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
