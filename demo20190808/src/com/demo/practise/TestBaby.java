package com.demo.practise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月08日  20:27:57
 */
public class TestBaby {

//    private SimpleDateFormat dateFormat = new SimpleDateFormat();

    public Object getInstance(String className) throws Exception {
        //反射到需要创建对象的路径
        Class classz = Class.forName(className);
        //得到对象
        Object object = classz.newInstance();
        //获得属性
        Field[] fields = classz.getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            //获得属性的注解
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation:annotations){
                //判断循环到的annotation是不是DateAnnotation的对象
                if(annotation instanceof DateAnnotation){
                    String value = ((DateAnnotation) annotation).value();
                    String pattern = ((DateAnnotation) annotation).pattern();
                    if("".equals(value)){
                        field.set(object,new Date());
                    }else{
                        SimpleDateFormat dateFormat = new SimpleDateFormat();
                        dateFormat.applyPattern(pattern);
                        field.set(object,dateFormat.parse(value));
                    }
                }
            }
        }
        return object;
    }

    public static void main(String[] args) {
        TestBaby testBaby = new TestBaby();
        try {
            Baby baby = (Baby) testBaby.getInstance("com.demo.practise.Baby");
            System.out.println(baby.getBirsthday());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
