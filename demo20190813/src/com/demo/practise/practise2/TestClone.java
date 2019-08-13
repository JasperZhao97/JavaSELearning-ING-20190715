package com.demo.practise.practise2;

import com.demo.practise.practise2.pojo.Class;
import com.demo.practise.practise2.pojo.Color;
import com.demo.practise.practise2.pojo.Student;

/**
 * 克隆测试类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  19:56:54
 */
public class TestClone {

    public static void main(String[] args) {
        try {
            //建立新的color对象
            Color color = new Color();
            ObjectClone objectClone = new ObjectClone();
            //克隆color对象
            Color color1 = objectClone.cloneObjecr(color);
            //查看color的地址
            System.out.println(color);
            System.out.println(color1);
            System.out.println(color.getRed());
            System.out.println(color1.getRed());

            //对Student类型的对象处理
            Class aclass = new Class("一年级一班");
            Student student = new Student("李红","女",18,aclass);
            Student student1 = objectClone.cloneObjecr(student);
            System.out.println("student:"+student.getName()+","+student.getGender()+","+student.getAge()+","+student.getaClass());
            System.out.println("student1:"+student1.getName()+","+student1.getGender()+","+student1.getAge()+","+student1.getaClass());
            System.out.println(student);
            System.out.println(student1);
            System.out.println(student.getaClass());
            System.out.println(student1.getaClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
