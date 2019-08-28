package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月28日  14:37:34
 */
public class Test {

    public static void main(String[] args) {
        /*List list = new ArrayList();
        list.add("CSDN_SEU_Calvin");
        list.add(100);
        for (int i = 0; i < list.size(); i++) {
            *//*String name = (String) list.get(i); //取出Integer时，运行时出现异常
            System.out.println("name:" + name);*//*
            System.out.println("name:" + list.get(i));
        }*/

        /*List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        li.add(new Integer(6));
        oa[1] = li; // Correct.
        Integer i = (Integer) lsa[1].get(0); // OK
        System.out.println(i);//3
        System.out.println(oa[1]);//[3,6]
        System.out.println(lsa[1]);//[3,6]
        System.out.println(lsa[1].get(0));
        System.out.println(lsa[1].get(1));*/

        /*//不能创建一个确切的泛型类型的数组。
        //List<String>[] datas = new ArrayList<>[10]; // error
        List<String>[] datas2 = new ArrayList[10]; // OK
        List<?>[] ls = new ArrayList<?>[10]; // Ok*/
    }
}
