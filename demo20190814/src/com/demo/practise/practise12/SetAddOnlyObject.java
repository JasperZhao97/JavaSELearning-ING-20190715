package com.demo.practise.practise12;

import com.demo.work.pojo.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * 定义类，自定义属性，必须有1个id属性；将对象添加到Set集合中
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 09:24:14
 */
public class SetAddOnlyObject {

    public static void main(String[] args) {
        //创建散列集
        Set<Person> set = new HashSet<>();
        //添加人员对象到集合中
        set.add(new Person("00001", "张山"));
        set.add(new Person("00002", "李丽"));
        set.add(new Person("00001", "王武")); //重复的对象，不会添加到集合中
        //遍历集合中元素
        for(Person p: set) {
            System.out.println(p.getId()+", "+p.getName());
        }
    }

}
