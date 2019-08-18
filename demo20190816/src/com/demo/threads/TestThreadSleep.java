package com.demo.threads;

/**
 * 测试应用线程sleep()方法
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月16日 16:48:44
 */
public class TestThreadSleep {

    public class PrintCharThread extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new TestThreadSleep().new PrintCharThread();
        t1.start();
    }

}
