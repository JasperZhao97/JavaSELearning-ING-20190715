package com.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * 不管真实角色的类存在多少个方法，动态代理类只需要重写一个invoke()方法，就可以访问真实角色对象的不同方法。
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月07日 16:30:48
 */
public class DynamicProxySubject implements InvocationHandler {

    private Subject subject; //目标对象（真实角色对象）

    public DynamicProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //访问目标对象（真实角色对象）的方法
        Object result = method.invoke(subject, args);
        return result;
    }
}
