package com.demo.reflection;

import com.demo.pojo.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 * 内省
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  15:23:00
 */
public class TestIntrospector {

    public static void main(String[] args) throws Exception {
        try {
            //创建Bean信息接口对象
            BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
            //获得所有的属性描述
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            //创建存放属性值的哈希表
            Hashtable hashtable = new Hashtable();
            hashtable.put("name", "Tom");
            hashtable.put("gender", "男");
            hashtable.put("age", 20);
            //创建Bean类对象
            Object object = Person.class.newInstance();
            //遍历属性描述数组
            for (PropertyDescriptor pro : propertyDescriptors) {
                //获得属性名称
                String fieldName = pro.getName();
//                System.out.println(fieldName);
                //设置属性值
                if (!"class".equals(fieldName)) {
                    //获得setter方法
                    Method method = pro.getWriteMethod();
                    //设值
                    method.invoke(object, hashtable.get(fieldName));//Bean类中未定义setter（）方法，运行时会抛出空指针异常
                }
            }

            for (PropertyDescriptor pro : propertyDescriptors) {
                //获得属性名称
                String fieldName = pro.getName();
                //设置属性值
                if (!"class".equals(fieldName)) {
                    //获得getter方法
                    Method method = pro.getReadMethod();
                    //设值
                    System.out.println(method.invoke(object));//Bean类中未定义setter（）方法，运行时会抛出空指针异常
                }                                             //若未存储setter（）方法的值，则会返回代码中默认的值
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
