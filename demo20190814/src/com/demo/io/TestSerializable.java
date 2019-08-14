package com.demo.io;

import com.demo.io.pojo.Student;

import java.io.*;

/**
 * 临时变量与类变量是否可以被序列化
 *     临时变量与类变量均不会被序列化
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 10:56:05
 */
public class TestSerializable {

    public static void main(String[] args) {
        try {
            Student stu1 = new Student();
            System.out.println(stu1.getName()+", "+stu1.getGender()+", "+stu1.getAge());

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("src/com/demo/io/data.ser"));
            out.writeObject(stu1);

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("src/com/demo/io/data.ser"));
            Student stu2 = (Student) in.readObject();

            System.out.println(stu2.getName()+", "+stu2.getGender()+", "+stu2.getAge());

            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
