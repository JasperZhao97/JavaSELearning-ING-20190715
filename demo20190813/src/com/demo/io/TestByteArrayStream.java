package com.demo.io;

import com.demo.io.pojo.Class;
import com.demo.io.pojo.Student;

import java.io.*;

/**
 * 字节数组输入输出流
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  16:14:44
 */
public class TestByteArrayStream {

    public static void main(String[] args) {
        try {
            //创建学生对象
            Class aclass = new Class("六年级五班");
            Student student = new Student("张三","男",21,aclass);
            //创建字节数组输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //建造对象输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            //克隆对象
            objectOutputStream.writeObject(student);
            //提取出克隆的对象
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            //
            Student student1 = (Student)objectInputStream.readObject();
            System.out.println("克隆的对象地址："+student1);
            System.out.println("被克隆的对象地址："+student);
            System.out.println(student1.getName()+","+student1.getGender()+","+student1.getAge()+","+student1.getaClass().getClassName());
            System.out.println("深度克隆的对象地址："+student1.getaClass());
            System.out.println("被深度克隆的对象地址："+student.getaClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
