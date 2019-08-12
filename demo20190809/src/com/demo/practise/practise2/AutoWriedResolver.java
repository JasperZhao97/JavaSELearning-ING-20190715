package com.demo.practise.practise2;

import java.lang.reflect.Field;

/**
 * 注解解析器类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月12日 15:21:50
 */
public class AutoWriedResolver {

    /**
     * 创建并返回实例对象
     * 查找使用了@AutoWried注解属性，为其赋予相应对象
     */
    public static Object getInstance(Class classz) throws Exception {
        //创建工厂容器对象
        CreatorFactory factory = CreatorFactory.getInstance("com.demo.work");
        //创建对象
        Object object = classz.newInstance();
        //获得类的所有属性
        Field[] fields = classz.getDeclaredFields();
        //遍历属性数组
        for(Field field: fields) {
            //获得自动自动装置注解
            AutoWried anno = field.getAnnotation(AutoWried.class);
            //System.out.println(anno);
            //判断是否获得自动装置注解
            if(anno!=null) {
                //查找工厂容器的对象
                Object fieldObject = factory.find(field.getType());
                //赋值给当前属性
                field.setAccessible(true);
                field.set(object, fieldObject);
            }
        }
        return object;
    }

}
