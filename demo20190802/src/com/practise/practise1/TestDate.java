package com.practise.practise1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月04日  16:42:05
 */
public class TestDate {

    public static void main(String[] args) {

        //通过方法，实例化对象
        DateUtils dateUtils = DateUtils.getInstance();

        //使用初始格式获取当前时间
        System.out.println(dateUtils.getTime());

        //设置指定日期时间，返回日期对象；
        Date date1 = dateUtils.setTime(2018,8,8,13,20,30);
        System.out.println(date1);

        //根据日期字符串与格式，返回日期对象；
        Date date2 = dateUtils.setStringDate("2018年12月12日 15:25:30","yyyy-MM-dd HH:mm:ss");
        System.out.println(date2);

        // 按照指定的格式与日期对象，返回格式化的日期字符串。
        Date date3 = new Date();
        System.out.println(dateUtils.setDateFormat(date3,"yyyy年MM月dd日 HH:mm:ss"));


    }
}
