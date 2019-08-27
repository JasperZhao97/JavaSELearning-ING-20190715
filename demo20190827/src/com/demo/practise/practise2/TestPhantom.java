package com.demo.practise.practise2;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 引用队列，监控对象是否被收回
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月27日  19:59:43
 */

class DataClass {
}

class MyPhantomReferenceTest extends PhantomReference<DataClass> {
    String name;

    public MyPhantomReferenceTest(DataClass dataClass, ReferenceQueue<DataClass> queue,String name) {
        super(dataClass, queue);
        this.name = name;
    }
}


public class TestPhantom {

    public static void main(String[] args) throws InterruptedException {
        DataClass dataClass = new DataClass();
        System.out.println(dataClass);
        ReferenceQueue<DataClass> queue = new ReferenceQueue<DataClass>();
        MyPhantomReferenceTest test = new MyPhantomReferenceTest(dataClass,queue,"test");
        dataClass = null;
        System.out.println(dataClass);
        System.gc();
        Reference ref = null;
        while ((ref=queue.poll())!=null){
            System.out.println(((MyPhantomReferenceTest)ref).name);
        }
    }
}
