package com.demo.collections;

import java.util.Vector;

/**
 * 测试应用向量
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 15:31:38
 */
public class TestVector {

    public static void main(String[] args) {
        //定义向量
        Vector vector = new Vector();
        //添加元素
        vector.add(100);
        vector.addElement(200);
        //插入元素
        vector.add(0, 10);
        vector.insertElementAt("Tom", 1);
        System.out.println(vector);
        //删除元素
        vector.remove(3);
        vector.removeElementAt(2);
        //输出向量集合
        System.out.println(vector);
    }

}
