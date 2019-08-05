package com.apis;

import java.util.Calendar;
import java.util.Date;

/**
 * 使用日历类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月02日 15:35:00
 */
public class TestCalendar {

    public static void main(String[] args) {
        /*//创建日历对象
        Calendar cal = Calendar.getInstance();
        //获得当前时间对象
        Date date = cal.getTime();
        System.out.println(date);
        //指定日期
        cal.set(2018, 12, 31);
        date = cal.getTime();
        System.out.println(date);
        cal.set(2018, 0, 31); //month 0...11
        date = cal.getTime();
        System.out.println(date);
        cal.set(2018, -2, 43);
        date = cal.getTime();
        System.out.println(date);*/
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
        cal.roll(Calendar.MONTH, true);
        System.out.println(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
        cal.roll(Calendar.MONTH, 3);
        System.out.println(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DAY_OF_MONTH));
    }

}
