package com.demo.practise.practise12;

import com.demo.work.pojo.Employee;
import com.demo.work.pojo.Person;
import com.demo.work.pojo.Student;

import java.util.Set;
import java.util.TreeSet;

/**
 * 定义两个类，两个类之间不存在is-a关系，设计程序让两个类的对象可以添加到同一个TreeSet集合中。
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 09:51:00
 */
public class TreeSetElementNoIsa {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>((o1, o2) -> {
            if(o1.getClass()!=o2.getClass()) {
                return 1;
            }
            return o1.getId().compareTo(o2.getId());
        });
        set.add(new Student("001", "张山"));
        set.add(new Employee("001", "张山1"));
        set.add(new Employee("002", "张山1"));
        set.add(new Employee("003", "张山1"));
        set.add(new Student("001", "张山2"));
        for (Person p: set) {
            System.out.println(p.getId()+", "+p.getName());
        }
    }

}
