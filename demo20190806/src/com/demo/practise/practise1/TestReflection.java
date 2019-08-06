package com.demo.practise.practise1;

/**
 * 反射测试类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  20:00:16
 */
public class TestReflection {

    public static void main(String[] args) {
        try {
//            Person person = (Person) Reflection.execute("Person","setName",new Object[]{"张三"});
            Reflection.execute("Person","setName",new Object[]{"张三"});
            Reflection.execute("Person","getName",new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
