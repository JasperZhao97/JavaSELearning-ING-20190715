package com.demo.genericity;

class Person {
}

class Employee extends Person {
}

class Manager extends Employee {
}

class Company<T> {
    public void show(T t) {
        System.out.println("company的show方法");
    }
}

/**
 * 有上下界限的泛型
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月07日  14:20:31
 */
public class TestGenericityBound {

    /**
     * 上界
     * 范围为Person类及其子类
     *
     * @param company
     */
    public void method(Company<? extends Person> company) {
        company.show(null);
//        company.show(new Object());//编译失败，不能确定一定能够上装型成功
//        company.show(new Person());//编译失败
//        company.show();
    }

    public void method2(Company<? super Person> company) {
        company.show(new Person());
        company.show(new Manager());
//        company.show(new Object());//编译失败
//        company.show();
    }

    public static void main(String[] args) {
        TestGenericityBound testGenericityBound = new TestGenericityBound();
        testGenericityBound.method(new Company<>());
//        testGenericityBound.method(new Company<Object>());//编译失败，只能在Person及Person的子类范围中
        testGenericityBound.method(new Company<Person>());
        testGenericityBound.method(new Company<Employee>());
        testGenericityBound.method(new Company<Manager>());
        System.out.println("-------------------------------");
        testGenericityBound.method(new Company<>());
        testGenericityBound.method2(new Company<Person>());
//        testGenericityBound.method2(new Company<Employee>());//编译失败，只能在Person及Person的父类范围中
//        testGenericityBound.method2(new Company<Manager>());//编译失败，只能在Person及Person的父类范围中
    }
}
