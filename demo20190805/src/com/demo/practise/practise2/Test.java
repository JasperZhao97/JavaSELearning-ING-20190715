package com.demo.practise.practise2;

import com.demo.reflection.Employee;
import com.demo.reflection.TestReflection;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  21:43:55
 */
public class Test {

    public static void main(String[] args) {
        TestReflection tr = new TestReflection();
        Employee employee = null;
        try {
            employee = (Employee) tr.creator("com.demo.reflection.Employee");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }
}
