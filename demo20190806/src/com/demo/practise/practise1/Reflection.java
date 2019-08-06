package com.demo.practise.practise1;

import sun.applet.Main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 方法实现类
 * 实现的方法：通过类的名字、方法名字、方法参数调用方法，返回值为该方法的返回值
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  20:01:05
 */
public class Reflection {

    public static Object execute(String className, String methodName, Object args[]) throws Exception {
        //获得类的对象
        className = "com.demo.practise.practise1." + className;
        Class classz = Class.forName(className);
        //创建className类的对象
        Object object = classz.newInstance();
        //创建空的方法变量
        Method method = null;
        //循环
        for (int i = 0; i < classz.getMethods().length; i++) {
            method = classz.getMethods()[i];
            if (methodName.equals(method.getName())) {
                method.invoke(object,args);
                break;
            }
        }
        return method.invoke(object,args);
//        return object;
    }
}
