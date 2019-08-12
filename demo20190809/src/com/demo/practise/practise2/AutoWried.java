package com.demo.practise.practise2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义自动装置对象的注解
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月12日 14:29:26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoWried {
}
