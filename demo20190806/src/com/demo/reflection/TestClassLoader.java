package com.demo.reflection;

import com.demo.pojo.Student;

/**
 * 类加载器
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月06日 17:44:33
 */
public class TestClassLoader {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader); //应用程序类加载器（系统类加载器）
        System.out.println(classLoader.getParent()); //扩展类加载器
        System.out.println(classLoader.getParent().getParent()); //启动类加载器（引导类加载器）
        //使用类加载器来加载类
        try {
            Class studentClass = classLoader.loadClass("com.demo.pojo.Student");
            Student student = (Student) studentClass.newInstance();
            student.setName("张山");
            System.out.println(student.getName()+","+student.getGender()+","+student.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
