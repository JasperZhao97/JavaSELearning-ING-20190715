package com.demo.practise.practise1;

import com.demo.practise.practise1.pojo.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月14日  19:17:45
 */
public class TestSet {

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet();
        studentSet.add(new Student("001","张三"));
        studentSet.add(new Student("003","李四"));
        studentSet.add(new Student("003","王麻子"));
        for(Student student:studentSet){
            System.out.println("学生学号："+student.getStuNumber()+"\t\t学生姓名："+student.getName());
        }
    }
}
