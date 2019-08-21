package com.demo.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  09:51:21
 */
public class Test1 {

//    private Timestamp timestamp;
//
//    public void show(Timer timer){
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        },timestamp,1000);
//    }

    public static void main(String[] args) {
        try {
            Date date = new Date(System.currentTimeMillis());
            System.out.println(date);
            String string = date.toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = "16:00:00";
            long date1 = dateFormat.parse(string+" "+time).getTime();
            System.out.println(date1);
            Timestamp timestamp = new Timestamp(dateFormat.parse(string+" "+time).getTime());
            System.out.println(timestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
