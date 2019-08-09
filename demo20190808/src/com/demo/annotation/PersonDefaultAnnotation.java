package com.demo.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//注解作用于类
@Retention(RetentionPolicy.RUNTIME)//指定生命周期
public @interface PersonDefaultAnnotation {
    public String userName();

    public String gender() default "男";

    public int age() default 1;

//    public Object object();//只能使用基本数据类型、String和Class
}
