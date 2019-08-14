package com.demo.collections;

import com.demo.work.pojo.Company;

import java.util.*;

/**
 * 测试应用规则集的3种集合
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 16:03:04
 */
public class TestSet {

    public static void main(String[] args) {
        //散列集
        /*Set<String> hashSet = new HashSet<>();
        hashSet.add("Tom");
        //hashSet.add(100); //编译失败，使用泛型限定元素只能String型*/
        //创建散列集
        Set hashSet = new HashSet(); //插入元素不保证顺序（无序），获取元素按照一定规则获取。
        //添加元素
        /*hashSet.add("Tom");
        hashSet.add(100);
        hashSet.add(new Company("中软国际"));*/
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(8);
        hashSet.add(7);
        hashSet.add(6);
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(40);
        hashSet.add(50);
        hashSet.add(80);
        hashSet.add(70);
        hashSet.add(60);
        //遍历集合
        for(Object o: hashSet) {
            System.out.print(o);
            System.out.print("\t");
        }
        System.out.println();
        /*//获得迭代器
        Iterator it = hashSet.iterator();
        //使用迭代器遍历集合
        while(it.hasNext()) {
            System.out.print(it.next());
            System.out.print("\t");
        }
        System.out.println();*/

        //创建链式散列集
        Set linkedHashSet = new LinkedHashSet(); //插入元素保证顺序（元素的插入先后为序）
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(8);
        linkedHashSet.add(7);
        linkedHashSet.add(6);
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.add(30);
        linkedHashSet.add(40);
        linkedHashSet.add(50);
        linkedHashSet.add(80);
        linkedHashSet.add(70);
        linkedHashSet.add(60);
        //遍历集合
        for(Object o: linkedHashSet) {
            System.out.print(o);
            System.out.print("\t");
        }
        System.out.println();

        //创建树型集
        Set treeSet = new TreeSet(hashSet); //插入元素时，以自然顺序对元素进行排序。
        treeSet.add(21);
        treeSet.add(0);
        treeSet.add(-10);
        /*treeSet.add("Tom"); //运行时报错，原因：不能与整型数值进行比较
        treeSet.add(null); //运行时报错  */
        //遍历集合
        for(Object o: treeSet) {
            System.out.print(o);
            System.out.print("\t");
        }
        System.out.println();
    }

}
