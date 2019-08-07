package com.demo.practise.practise2;

/**
 * 测试类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  22:42:58
 */
public class Test {

    //定义方法，通过接口访问不同的实现类的对象
    public void method() {

    }

    public static void main(String[] args) {
//        Factory factory = new Factory();
//        System.out.println(factory.print());
        Factory factory = new Factory();
        try {
            Animals animals = factory.methodInstance("Cat");
            System.out.println(animals);
            System.out.println(animals.voice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
