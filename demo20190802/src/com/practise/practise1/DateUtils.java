package com.practise.practise1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月04日  17:39:53
 */
public class DateUtils {

    //不能实例化DateUtils对象
    private static DateUtils instance = new DateUtils();

    public DateUtils() {
    }

    //通过方法获得对象
    public static DateUtils getInstance() {
        return instance;
    }

    //设置默认日期格式
    public DateFormat setDefaultDateFormat() {
        return new SimpleDateFormat("yyyy年MM月dd日");
    }

    //获得当前时间
    public String getTime() {
        Date date = new Date();
        String str = setDefaultDateFormat().format(date);
        return str;
    }

    //根据日期字符串与格式，返回日期对象；
    public Date setStringDate(String string, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = dateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    // 按照指定的格式与日期对象，返回格式化的日期字符串。
    public String setDateFormat(Date date,String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date2 = new Date();
        String str = dateFormat.format(date);
        return str;
    }

    //设置指定日期时间，返回日期对象；
    public Date setTime(int year, int month, int date, int hourOfDay, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,date,hourOfDay,minute,second);
        Date date1 = calendar.getTime();
        return date1;
    }
}
