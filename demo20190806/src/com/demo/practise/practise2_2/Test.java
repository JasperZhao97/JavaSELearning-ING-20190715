package com.demo.practise.practise2_2;

/**
 * 测试类
 *
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月08日 10:07:00
 */
public class Test {

    public static void main(String[] args) {
        try {
            //获得工厂对象
            Factory factory = Factory.getInstance();
            //查找获取接口实现类对象
            ICalculator ical = factory.find("com.demo.practise.practise2_2.impl.SimpleCalculator");
            System.out.println(ical.sum(10, 20.5878));
            System.out.println(ical.subtraction(100.798, 95.6));
            ical = factory.find("com.demo.practise.practise2_2.impl.ValidNumberCalculator");
            System.out.println(ical.sum(10, 20.5878));
            System.out.println(ical.subtraction(100.798, 95.6));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
