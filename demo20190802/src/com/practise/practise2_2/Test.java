package com.practise.practise2_2;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  22:06:27
 */
public class Test {

    public static void main(String[] args) {
        StudentService ss = new StudentService();
        System.out.println(ss.formatJSON(new Student("张山", "男", 21)));
        System.out.println(ss.formatJSON(new Student[]{
                new Student("张山", "男", 21),
                new Student("李四", "男", 22),
                new Student("王舞", "女", 20)
        }));
    }
}
