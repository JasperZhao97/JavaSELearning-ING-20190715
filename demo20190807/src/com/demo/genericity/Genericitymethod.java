package com.demo.genericity;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月07日  13:46:37
 */
public class Genericitymethod {

    /**
     *
     * @param t
     * @param <T>//调用方法时确定泛型的类型，该类型就是参数的类型
     * @return
     */
    public <T> T method(T t) {
        return t;
    }

    public static void main(String[] args) {
        Genericitymethod genericitymethod = new Genericitymethod();
        System.out.println(genericitymethod.method("Tom"));

    }
}
