package com.demo.practise.practise2.impl;

import com.demo.practise.practise2.Animals;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  22:36:28
 */
public class Cat implements Animals {

    private String fish;

    public Cat() {
    }

    public Cat(String fish) {
        this.fish = fish;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    @Override
    public String voice() {
        return "喵喵喵";
    }
}
