package com.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试职员类中所应用的日期注解
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月08日  15:28:17
 */
public class TestEmployee {

    //创建时间格式化对象
    private SimpleDateFormat dateFormat = new SimpleDateFormat();

    /**
     * 使用反射获得对象，同时解析注解
     *
     * @param className
     * @return
     * @throws Exception
     */
    public Object getInstance(String className) throws Exception {
        Class classz = Class.forName(className);
        Object object = classz.newInstance();
        //获得所有的注解
//        Annotation[] annotations = classz.getDeclaredAnnotations();
//        for(Annotation annotation:annotations){
//            System.out.println("---");
//            System.out.println(annotation instanceof DateAnnotation);
//            if(annotation instanceof DateAnnotation){
//
//            }
//        }
        //获得所有属性
        Field[] fields = classz.getDeclaredFields();
        //遍历属性数组
        for (Field field : fields) {
            //取消属性的访问检测，即允许访问
            field.setAccessible(true);
            //获得属性的所有的注解
            Annotation[] annotations = field.getDeclaredAnnotations();
            //遍历属性的注解数组
            for (Annotation annotation : annotations) {
                if (annotation instanceof DateAnnotation) {
                    //下转型
                    DateAnnotation dateAnnotation = (DateAnnotation) annotation;
                    //获得注解中的属性值
                    String value = dateAnnotation.value();
                    String pattern = dateAnnotation.pattern();
                    //判断value是否为“”
                    if ("".equals(value)) {
                        field.set(object, new Date());
                    } else {
                        //修改日期格式
                        dateFormat.applyPattern(pattern);
                        //格式化value时间字符串，生成日期对象赋值给注解标注的属性
                        field.set(object, dateFormat.parse(value));
                    }
                }
            }
        }
        return object;
    }

    public static void main(String[] args) {
        TestEmployee testEmployee = new TestEmployee();
        try {
            Employee employee = (Employee) testEmployee.getInstance("com.demo.annotation.Employee");
            System.out.println(employee.getInTime() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
