package com.demo.genericity;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * 编译后，程序互采取去泛型化操作
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月07日  15:06:23
 */
public class Test1 {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        System.out.println(classIntegerArrayList);//输出class java.util.ArrayList
        System.out.println(classStringArrayList);//输出class java.util.ArrayList
        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println(("泛型测试"+"类型相同"));//运行后将会输出这段
        }
    }
}
