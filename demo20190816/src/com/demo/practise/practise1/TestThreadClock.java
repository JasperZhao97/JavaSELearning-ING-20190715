package com.demo.practise.practise1;

import java.util.Date;

/**
 * 利用线程设置闹钟
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月16日  20:04:12
 */

class PrintThread extends Thread {

    private Date startTime;//闹钟开始响铃时间
    private int clockTime;//闹铃响的时长
    private int number; //闹钟的响铃重复响铃次数
    private int time; //闹钟响铃的间隔时间

    public PrintThread() {

    }

    public PrintThread(int clockTime, int number, int time) {
        this.clockTime = clockTime;
        this.number = number;
        this .time = time;
    }

    @Override
    public void run() {
        try {
            Date date = new Date();
            //响铃持续number时间
            for (int j = 0;j<number;j++) {
                //单次响铃时间为clockTime秒钟
                for (int i = 0; i < clockTime/500; i++) {
                    System.out.println("主人起床了！！！");
                    sleep(500);
                }
                System.out.println("闹钟已响铃"+(j+1)+"次");
                System.out.println("-----------------------");
                //闹钟再次响的时间间隔为time秒钟
                sleep(time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class TestThreadClock {

    public static void main(String[] args) {
        Thread t1 = new PrintThread(3000,2,5000);
        t1.start();
    }

}
