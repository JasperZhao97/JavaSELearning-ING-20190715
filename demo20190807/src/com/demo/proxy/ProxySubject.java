package com.demo.proxy;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月07日 16:02:17
 */
public class ProxySubject implements Subject {

    private Subject subject; //定义抽象类变量，关联真实类对象

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        subject.request();
    }
}
