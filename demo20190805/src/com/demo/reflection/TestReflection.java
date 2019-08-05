package com.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 使用反射机制
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  16:26:09
 */
public class TestReflection {

    /**
     * 创建对象
     * 反射是一种动态创建对象及访问对象的方式
     * @param className
     * @return
     */
    public Object creator(String className) throws Exception {
        //加载类
        Class objectClass = Class.forName(className);
        //创建对象
        Object object = objectClass.newInstance();
        return object;
    }

    /**
     * 使用构造器创建并初始化对象
     * @param className
     * @param params
     * @param values
     * @return
     * @throws Exception
     */
    public Object creator(String className, Class[] params, Object[] values) throws Exception {
        Class objectClass = Class.forName(className);
        //获得构造器
        Constructor constructor = objectClass.getConstructor(params);
        //创建对象
        Object object = constructor.newInstance(values);
        return object;
    }

    public static void main(String[] args) {
        try {
            /*//加载类
            Class employeeClass = Class.forName("com.demo.reflection.Employee");
            //创建对象
            Employee employee = (Employee) employeeClass.newInstance();
            System.out.println(employee);*/
            TestReflection tr = new TestReflection();
            Employee employee = (Employee) tr.creator("com.demo.reflection.Employee");
            System.out.println(employee);

            Employee employee2 = (Employee) tr.creator("com.demo.reflection.Employee",
                    new Class[]{Class.forName("java.lang.String"), String.class, int.class},
                    new Object[]{"张山", "男", 22});
            System.out.println(employee2);

            //使用构造器创建对象
            //Class employeeClass = Class.forName("com.demo.reflection.Employee");
            Class employeeClass = Employee.class;
            Constructor employeeConstructor = employeeClass.getConstructor(String.class, String.class, int.class);
            Employee employee3 = (Employee) employeeConstructor.newInstance("张山", "男", 20);
            System.out.println(employee3);

            //Class的newInstance()方法创建对象，直接访问属性初始化
            Class employeeClass4 = Employee.class;
            Employee employee4 = (Employee) employeeClass4.newInstance();
            //获得属性
            Field nameField = employeeClass4.getField("name"); //getField(); 只能获得到拥有访问权限属性
            /*Field genderField = employeeClass4.getField("gender");
            Field ageField = employeeClass4.getField("age");*/
            Field genderField = employeeClass4.getDeclaredField("gender"); //getDeclaredField(); 可以获得任意访问权限的属性
            Field ageField = employeeClass4.getDeclaredField("age");
            //设置属性值， 只能给拥有访问权限的属性设置。
            nameField.set(employee4, "李丽");
            //对于没有访问权限的属性，需要取消访问权限检测, 允许属性可以被访问
            genderField.setAccessible(true);
            ageField.setAccessible(true);
            genderField.set(employee4, "女");
            ageField.set(employee4, 25);
            System.out.println(employee4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
