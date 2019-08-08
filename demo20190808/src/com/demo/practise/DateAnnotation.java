package com.demo.practise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.DateFormat;
import java.util.Date;

/**
 * 日期注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateAnnotation {

    public String value() default "";
    public String pattern() default "yyyy-MM-dd HH:mm:ss";
}
