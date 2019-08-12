package com.demo.practise.practise2;

import com.demo.work.impl.PersonServiceImpl;

import java.lang.reflect.Field;
import java.text.Annotation;

/**
 * 测试类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月12日 14:44:34
 */
public class Test {

    @AutoWried
    private PersonServiceImpl personService;

    public void method() {
        personService.method();
    }

    public static void main(String[] args) {
        try {
            Test test = (Test) AutoWriedResolver.getInstance(Test.class);
            TestAutoWried testAuto = (TestAutoWried) AutoWriedResolver.getInstance(TestAutoWried.class);
            test.method();
            testAuto.service();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
