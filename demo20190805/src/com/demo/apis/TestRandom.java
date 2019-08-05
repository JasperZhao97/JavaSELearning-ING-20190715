package com.demo.apis;

import java.awt.*;
import java.util.Random;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  14:05:26
 */
public class TestRandom {

    public static void main(String[] args) {
        Random random1 = new Random(50);
        Random random2 = new Random(50);
        System.out.println(random1.nextInt(100));
        System.out.println(random2.nextInt(100));
    }
}
