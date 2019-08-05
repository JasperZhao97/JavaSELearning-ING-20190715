package com.practise.practise1_2;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  10:25:15
 */
public class Test {

    public static void main(String[] args) {
        DateUtils dateUtils = DateUtils.getInstance();
        //获得当前时间
        System.out.println(dateUtils.currentDate());
        //使用默认日期格式获得是时间
        System.out.println(dateUtils.format(dateUtils.currentDate()));
        //获得指定日期的日期对象
        System.out.println(dateUtils.getDate(2006,8,16));
    }
}
