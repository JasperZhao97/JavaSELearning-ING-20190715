package com.demo.test;


import java.util.Date;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月27日  10:30:32
 */
public class Example extends Date {

    public static void main(String[] args) {
        new Example().test();
    }

    public void test() {
        System.out.println(super.getClass().getName());
    }
}
