package com.demo.reflection;

import java.util.Hashtable;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  15:34:22
 */
public class TestHashTable {

    public static void main(String[] args) {
        //创建哈希表对象
        Hashtable hashtable = new Hashtable();
        //设值
        hashtable.put("name","Tom");
        hashtable.put("age",19);
        //输出整个Hash表
        System.out.println(hashtable);
        //取值
        System.out.println(hashtable.get("name")+" "+hashtable.get("age"));
        //以字符串输出整个hash表
        System.out.println(hashtable.toString());


    }
}
