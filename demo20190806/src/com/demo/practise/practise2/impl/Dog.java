package com.demo.practise.practise2.impl;

import com.demo.practise.practise2.Animals;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  22:36:40
 */
public class Dog implements Animals {

    private String bone;

    public Dog() {
    }

    public Dog(String bone) {
        this.bone = bone;
    }

    public String getBone() {
        return bone;
    }

    public void setBone(String bone) {
        this.bone = bone;
    }

    @Override
    public String voice() {
        return "汪汪汪";
    }
}
