package com.demo.practise.practise2;

import java.lang.reflect.Constructor;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  20:50:11
 */
public class ReflectionCreator {

    /**
     *创建方法
     * @param className
     * @return
     */
    public Object creator(String className) throws Exception {
        //加载类
        Class objectClass = Class.forName(className);
        //创建对象
        Object object = objectClass.newInstance();
        return object;
    }
}
