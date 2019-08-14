package com.demo.practise.practise2;


import com.demo.practise.practise2.pojo.Employee;
import com.demo.practise.practise2.pojo.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月14日  20:18:08
 */
public class TestTree {

    public static <T> void main(String[] args) {
        Set<T> mySet = new TreeSet<>(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.hashCode();
            }
        });
        mySet.add((T) new Student("001","张三"));
        mySet.add((T) new Student("002","李四 "));
        mySet.add((T) new Employee("001","莉莉"));
        mySet.add((T) new Employee("002","张斌"));
        for (T t:mySet){
            System.out.println(t.toString());
        }
    }
}
