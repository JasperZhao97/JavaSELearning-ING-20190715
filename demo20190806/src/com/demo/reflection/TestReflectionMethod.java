package com.demo.reflection;

import com.demo.pojo.Student;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试反射机制
 * 访问方法
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  13:49:33
 */
public class TestReflectionMethod {

    /**
     * 创建学生对象
     * @param name
     * @param gender
     * @param age
     * @return
     */
    public Student createStudent(String name,String gender,Integer age) throws Exception {
        //获得引用类对象
        Class classz = Student.class;
        //用引用的类对象方法创建Student的对象
        Student student = (Student) classz.newInstance();
        //获得方法并通过方法设置属性的值
        Method method = classz.getMethod("setName", String.class);
        //调用方法设置值
        method.invoke(student,name);
        method = classz.getMethod("setGender", String.class);
        method.invoke(student,gender);
        method = classz.getMethod("setAge", Integer.class);
        method.invoke(student,age);
        return student;
    }

    /**
     * 创建任意对象
     * 通过方法设置属性的值
     * @param classz
     * @param params
     * @return
     */
    public Object creator(Class classz,Object[] params) throws Exception {
        //创建对象
        Object object = classz.newInstance();
        //获得所有的属性
        Field[] fields = classz.getDeclaredFields();
        //遍历属性数组
        for (int i = 0;i<fields.length;i++){
            //获得当前属性
            Field field = fields[i];
            //获得属性
            String fieldName = field.getName();
            //获得方法名
            String methodName = "set"+String.valueOf(fieldName.charAt(0)).toUpperCase()+fieldName.substring(1);
            //获得方法对象
            Method method = classz.getMethod(methodName,field.getType());
            //调用方法设置属性的值
            method.invoke(object,params[i]);
        }
        return object;
    }

    public static void main(String[] args) throws Exception {
        TestReflectionMethod testReflectionMethod = new TestReflectionMethod();
        Student student = testReflectionMethod.createStudent("张三","男",20);
        System.out.println(student.getName()+" "+student.getGender()+" "+student.getAge());
        System.out.println("--------------------------");
        Student student2 = (Student)testReflectionMethod.creator(Student.class,new Object[]{"莉莉","女",18});
        System.out.println(student2.getName()+" "+student2.getGender()+" "+student2.getAge());
    }
}
