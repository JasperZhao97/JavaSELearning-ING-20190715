package com.demo.test;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月28日  15:01:46
 */
public class Test1 {

    private int count;

    public static int getInstanceCount(){
        //return count;//编译错误，静态方法不能引用实例成员
        return 0;
    }

    public Test1() {
        count++;
    }

    public static void main(String[] args) {
        new Test1();
        new Test1();
        new Test1();
        System.out.println(Test1.getInstanceCount());
    }
}
