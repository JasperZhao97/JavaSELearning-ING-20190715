package com.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月08日  14:01:17
 */
public class TestPerson {

    public Person getPersonInstance() throws Exception {
        //获得人员类的类信息对象
        Class classz = Person.class;
        //获得注解
        PersonDefaultAnnotation pda = (PersonDefaultAnnotation) classz.getAnnotation(PersonDefaultAnnotation.class);
//        //获得注解的属性
//        String userName = pda.userName();
//        String gender = pda.gender();
//        int age = pda.age();
//        //创建人员对象
//        Person person = (Person) classz.newInstance();
//        Field field = classz.getDeclaredField("userName");
//        field.setAccessible(true);
//        field.set(person,userName);
//        field = classz.getDeclaredField("gender");
//        field.setAccessible(true);
//        field.set(person,gender);
//        field = classz.getDeclaredField("age");
//        field.setAccessible(true);
//        field.set(person,age);
        //创建人员对象
        Person person = (Person)classz.newInstance();
        //获得人员类的所有属性
        Field[] fields = classz.getDeclaredFields();
        for(Field field:fields){
            //取消访问权限检查
            field.setAccessible(true);
//            //给属性设置
//            field.set(person,null);
            //获得注解的Class对象
            Class aclassz = pda.getClass();
            //获得当前属性对象注解中的属性(反射中当成方法处理)
            Method method = aclassz.getMethod(field.getName());
            //访问方法
            Object object = method.invoke(pda);
            //给属性设置
            field.set(person,pda.getClass().getMethod(field.getName()).invoke(pda));
        }
        return person;
    }

    public static void main(String[] args) throws Exception {
        TestPerson testPerson = new TestPerson();
        Person person = testPerson.getPersonInstance();
        System.out.println(person.getUsername()+" "+person.getGender()+" "+person.getAge());
    }
}
