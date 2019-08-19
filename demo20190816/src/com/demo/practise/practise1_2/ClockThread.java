package com.demo.practise.practise1_2;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用线程设置闹钟程序
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月19日 10:11:31
 */
public class ClockThread extends Thread {

    private String time;
    private Timestamp applyDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ClockThread(String time) {
        try {
            this.time = time;
            //获得当前时间对象
            Date currentDate = new Date(System.currentTimeMillis());
            //获得当前时间的年月日
            String strgCurentDate = currentDate.toString();
            //获得设置的时间
            applyDate = new Timestamp(dateFormat.parse(strgCurentDate+" "+time).getTime());
            //System.out.println(applyDate);
            //判断设置的时间是否小于当前时间
            if(applyDate.before(currentDate)) {
               applyDate = new Timestamp(applyDate.getTime()+24*60*60*1000);
            }
            //System.out.println(applyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //添加定时器
    public void addTimertask(Timer timer) {
        //给定时器添加入任务
        timer.schedule(new TimerTask() {
            //定义变量记录响的次数
            int count = 0;
            @Override
            public void run() {
                System.out.println("时间到了......");
                count++;
                if(count>=3) {
                    //取消当前定时器
                    this.cancel();
                    //修改闹钟下一次响的时间
                    applyDate = new Timestamp(System.currentTimeMillis()+10000);
                    //再次添加定时器
                    addTimertask(timer);
                }
            }
        }, applyDate, 2000);
    }

    @Override
    public void run() {
        //创建定时器对象
        Timer timer = new Timer();
        //访问添加定时器的方法
        addTimertask(timer);
    }

    public static void main(String[] args) {
        ClockThread t1 = new ClockThread("11:13:50");
        t1.start();
    }

}
