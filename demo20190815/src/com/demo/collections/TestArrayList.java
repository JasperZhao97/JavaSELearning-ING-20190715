package com.demo.collections;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试应用数组线性表
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 14:02:24
 */
public class TestArrayList {

    public static void main(String[] args) {
        //创建数组线性表集合
        ArrayList list = new ArrayList();
        list.add(1000);
        list.add(100.25);
        list.add('渝');
        list.add(true);
        list.add(1000);
        list.add(100.25);
        list.add('渝');
        list.add(true);
        list.add(1000);
        list.add(100.25);
        list.add('渝');
        list.add(true);
        System.out.println(list);
        /*for(Object o: list) {
            System.out.print(o+" ");
        }
        System.out.println();*/
        //通过下标获取元素
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
        //插入元素
        list.add(2, "重庆1");
        System.out.println(list);
        //修改元素
        list.set(3, "重庆");
        System.out.println(list);
        //删除元素
        list.remove(4);
        System.out.println(list);
        //查找元素
        System.out.println(list.indexOf('渝'));
    }

}
