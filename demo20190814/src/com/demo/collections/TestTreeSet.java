package com.demo.collections;

import com.demo.collections.pojo.Employee;
import com.demo.collections.pojo.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 测试应用树型集
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 16:44:24
 */
public class TestTreeSet {

    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("CQ00001","张山")); //TreeSet集合中元素必须可以进行相互比较，否则运行报错
        set.add(new Student("CQ00006","李丽"));
        set.add(new Student("CQ00003","王武"));
        for (Student s: set) {
            System.out.println(s.getNumber()+", "+s.getName()+"\t\t");
        }
        System.out.println("------------------------------------------");
        //创建树型集，指定比较器
        Set<Employee> empSet = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //return o1.getSalary()-o2.getSalary();
                return o2.getSalary()-o1.getSalary();
            }
        });
        empSet.add(new Employee("张龙", 5000));
        empSet.add(new Employee("王璐", 4500));
        empSet.add(new Employee("田齐", 3800));
        for (Employee e: empSet) {
            System.out.println(e.getName()+", "+e.getSalary()+"\t\t");
        }
        System.out.println("------------------------------------------");
        //创建树型集，使用Lambda表达式指定比较器
        //Set<Employee> empSet2 = new TreeSet<>((o1, o2) -> o1.getSalary()-o2.getSalary());
        Set<Employee> empSet2 = new TreeSet<>((o1, o2) -> {
            return  o1.getSalary()-o2.getSalary();
        });
        empSet2.add(new Employee("张龙", 5000));
        empSet2.add(new Employee("王璐", 4500));
        empSet2.add(new Employee("田齐", 3800));
        for (Employee e: empSet2) {
            System.out.println(e.getName()+", "+e.getSalary()+"\t\t");
        }
    }

}
