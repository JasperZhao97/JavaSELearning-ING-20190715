package com.practise.practise1_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  09:47:30
 */
public class DateUtils {

    /*private String defaultDateFormat = "yyyy-MM-dd";//默认时间格式
    Calendar calendar = Calendar.getInstance();
    private DateFormat dateFormat = new SimpleDateFormat(defaultDateFormat);*/
    private String defaultDateFormat;//默认时间格式
    Calendar calendar;
    private SimpleDateFormat dateFormat;

    private DateUtils() {
        defaultDateFormat = "yyyy-MM-dd";
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat(defaultDateFormat);
    }

    public static DateUtils getInstance() {
        return new DateUtils();
    }

    public String getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public void setDefaultDateFormat(String defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    /**
     * 获得当前日期
     * @return
     */
    public Date currentDate() {
        return new Date();
    }

    /**
     * 设置年月日，返回日期对象
     * @param year
     * @param month
     * @param day
     * @return
     */
    public Date getDate(int year,int month,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month+1,day);
        return calendar.getTime();
    }

    /**
     * 设置年月日时分秒，返回日期对象
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param minute 分
     * @param second 秒
     * @return
     */
    public Date getDate(int year,int month,int day,int hour,int minute,int second) {
        calendar.set(year,month-1,day,hour,minute,second);
        return calendar.getTime();
    }

    /**
     * 格式化日期字符串，返回日期对象
     * @param strDate
     * @return
     */
    public Date parse(String strDate) throws ParseException {
        return dateFormat.parse(strDate);
    }

    /**
     * 格式化日期字符串，返回日期对象
     * @param strDate
     * @param pattern
     * @return
     * @throws ParseException
     */
    public Date parse(String strDate,String pattern) throws ParseException {
        dateFormat.applyPattern(pattern);
        return dateFormat.parse(strDate);
    }

    /**
     * 格式化日期对象，返回字符串
     * @param date
     * @return
     */
    public String format(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 根据指定类型格式化日期对象，返回字符串
     * @param date
     * @param pattern
     * @return
     */
    public String format(Date date,String pattern) {
        dateFormat.applyPattern(pattern);
        return dateFormat.format(date);
    }
}
