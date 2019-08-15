package com.demo.collections;

import java.util.LinkedList;

/**
 * 测试应用链表
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 14:28:55
 */
public class TestLinkedList {

    public static void main(String[] args) {
        //创建链表
        LinkedList list = new LinkedList();
        //添加元素
        list.add(100);
        list.add(120);
        list.add(100);
        //插入元素
        list.addFirst("start");
        list.addLast("end");
        list.add(3, 10000);
        //修改元素
        list.set(1, 10);
        //删除元素
        list.remove(3);
        list.removeFirst();
        list.removeLast();
        //输出集合
        System.out.println(list);
        //获取元素
       /* for(int i=0; i<list.size(); i++) {
            Object o = list.get(i);
            System.out.print(o+" ");
        }
        System.out.println();*/
    }

}
