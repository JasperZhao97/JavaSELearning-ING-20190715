package com.demo.practise.practise1;

/**
 * 测试类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  20:22:58
 */
public class Test {

    public static void main(String[] args) {
        //创建有5个线程的线程池
        MyThreadPool service = new MyThreadPool(5);
//        for(int i = 0;i<10;i++){
//            service.excute(new Thread());
//        }

        class TaskRunnable extends Thread{

            @Override
            public void run(){
                System.out.println(currentThread());
            }
        }
    }
}
