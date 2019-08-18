package com.demo.practise.practise12;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 自定义实现数组线性表或链表
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月16日 10:07:43
 */
public class MyArrayList<E> implements Iterable<E> {

    private Object[] elements = new Object[10]; //存放元素的数组
    private int size; //元素的个数

    public void add(E e) {
        //判断是否超出容量范围，将容量扩充1倍
        if(size==elements.length) {
            elements = Arrays.copyOf(elements, elements.length << 1);
        }
        //尾部追加元素
        elements[size++] = e;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor<size();
            }

            @Override
            public E next() {
                return get(cursor++);
            }
        };
    }
}
