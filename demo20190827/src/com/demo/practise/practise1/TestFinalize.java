package com.demo.practise.practise1;

/**
 * 重写finalize方法
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月27日  19:28:13
 */
public class TestFinalize {

    public static void main(String[] args) {
        Student student = new Student("张三",20);
        System.out.println(student);
        student = null;
        System.gc();
        System.out.println(student);
    }
}
