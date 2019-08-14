package com.demo.practise.practise12;

import com.demo.practise.practise12.pojo.Company;
import com.demo.practise.practise12.pojo.Employee;

import java.io.*;

/**
 * 克隆对象
 *
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 10:15:29
 */
public class CloneObject {

    /**
     * 克隆任意类型对象
     *
     * @param object
     * @param <T>
     * @return
     */
    public <T> T clone(T object) throws Exception {
        //创建字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //创建对象输出流
        ObjectOutputStream out = new ObjectOutputStream(baos);
        //输出对象
        out.writeObject(object);
        //创建对象输入流
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        //读取流对象
        T obj = (T) in.readObject();
        //关闭流
        out.close();
        in.close();
        return obj;
    }

    public static void main(String[] args) {
        try {
            CloneObject co = new CloneObject();
            Employee emp1 = new Employee("王武", new Company("中软国际"));
            System.out.println(emp1.getName() + ", " + emp1.getCompany().getName());
            System.out.println(emp1);
            System.out.println(emp1.getCompany());
            //克隆对象
            Employee emp2 = co.clone(emp1);
            System.out.println(emp2.getName()+", "+emp2.getCompany().getName());
            System.out.println(emp2);
            System.out.println(emp2.getCompany());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
