package com.demo.practise.practise2.pojo;

import com.demo.practise.practise2.pojo.Red;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  20:02:05
 */
public class Color implements Serializable {

    private Red red;

    public Color() {
        this.red = new Red();
    }

    public Color(Red red) {
        this.red = red;
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }
}
