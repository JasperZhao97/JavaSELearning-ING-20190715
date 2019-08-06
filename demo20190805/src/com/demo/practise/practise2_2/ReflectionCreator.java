package com.demo.practise.practise2_2;

/**
 * 定义类ReflectionCreator,定义一个可以创建并初始化任意类对象的通用方法
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月06日 11:25:52
 */
public class ReflectionCreator {

    public static Object creator(Class classz, Class[] paramTypes, Object[] params) throws Exception {
        return classz.getConstructor(paramTypes).newInstance(params);
    }

}
