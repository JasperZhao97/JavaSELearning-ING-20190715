package com.demo.practise.practise12;

/**
 * 测试自定义的数组线性表
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月16日 10:21:49
 */
public class TestMyArrayList {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Tom");
        list.add("Lily");
        list.add("Jack");
        list.add("Rose");
        for(String str: list) {
            System.out.println(str);
        }
        System.out.println("程序执行完毕!");
    }

}
