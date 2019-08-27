package com.demo.test;

/**
 * 月考试题
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月27日  10:26:16
 */
public class Test {
    public static void main(String[] args) {

        GT<Integer> gti = new GT<Integer>();
        gti.var = 1;
        GT<String> gts = new GT<String>();
        gts.var = 2;
        System.out.println(gti.var);
    }
}

class GT<T> {

    public static int var = 0;
    public void nothing(T t) {
    }
}
