package com.demo.genericity;

/**
 * 泛型类
 *
 * @param <E>
 */
class MyArrayList<E> {
    //使用泛型变量创建数组
    private E[] array;
    private int capacity;
    private int size;

    public MyArrayList() {
        capacity = 16;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    public Object[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(E e) {
        array[size++] = e;
    }

    public E get(int index) {
        return array[index];
    }

}

/**
 * 泛型类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月07日  10:50:41
 */
public class GenericityClass {

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();//泛型默认为Object型
        list.add(10);
        list.add("Tom");
        System.out.println(list.get(0) + " " + list.get(1));

        MyArrayList<String> list2 = new MyArrayList<>();
        //list2.add(12);//编译失败，只能添加String型数据
        list2.add("张三");
        list2.add("李四");
        for (int i = 0; i < list2.getSize(); i++) {

        }
//        MyArrayList<int>list3 = new MyArrayList<int>();//编译失败，使用泛型时，不能使用基础类型
    }
}
