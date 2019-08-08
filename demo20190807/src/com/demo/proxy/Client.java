package com.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * 客户程序
 * 使用代理对象访问真实对象
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月07日 16:07:52
 */
public class Client {

    public static void main(String[] args) {
        //静态代理
        /*Subject subject = new RealSubject();
        Subject proxy = new ProxySubject(subject);
        proxy.request();*/

        //动态代理
        //创建真实角色类对象作为目标对象
        Subject subject = new RealSubject();
        //创建动态代理对象
        DynamicProxySubject proxySubject = new DynamicProxySubject(subject);
        //将动态代理对象转型给抽象角色的类或接口的引用
        //Subject proxy = (Subject) proxySubject;  //编译失败，不存在is-a关系
        //Proxy类创建代理对象
        Subject proxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Subject.class}, proxySubject);
        //访问真实角色类对象的方法
        proxy.request();
    }

}
