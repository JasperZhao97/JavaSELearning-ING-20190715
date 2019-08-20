package com.demo.threads;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * 测试应用四种线程池
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月20日 11:00:48
 */
public class TestThreadPool {

    private static class TaskRunable extends Thread {

        public int id;  //任务ID（编号）

        public TaskRunable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println(currentThread().getName() + "   任务" + id);
                //sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
       /* //单例线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        //循环添加多个任务
        for(int i=1; i<=10; i++) {
            service.execute(new TaskRunable(i)); //线程执行阻塞队列中的任务是有序的，按照先入先出的顺序。
        }
        //所有任务执行完毕后，结束线程池中线程
        service.shutdown();*/
       /*try {
           //固定大小线程池
           ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
           //循环添加多个任务
           for (int i = 1; i <= 100; i++) {
               service.execute(new TaskRunable(i));
           }
           //所有任务执行完毕后，销毁池中所有线程
           service.shutdown();
           //System.out.println(service.isShutdown());
           //判断线程是否都执行完任务
           while (service.getActiveCount()>0) {
               Thread.sleep(500);
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           System.out.println("程序执行完毕!");
       }*/
       //无界线程池
       /*ExecutorService service = Executors.newCachedThreadPool();
       for(int i=1; i<=100; i++) {
           service.execute(new TaskRunable(i));
       }
       service.shutdown();*/
       //定时周期执行任务线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.schedule(new Thread() {
            @Override
            public void run() {
                System.out.println(currentThread().getName()+"执行定时任务!");
            }
        }, 5, TimeUnit.SECONDS);
        service.shutdown();
    }

}
