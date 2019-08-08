package com.demo.proxy;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月07日 16:01:50
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("执行真实角色（具体类）总方法!");
    }
}
