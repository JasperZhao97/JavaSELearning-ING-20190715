package com.demo.threads;

/**
 * 异常结束线程
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月16日 17:12:13
 */
public class TestStopThread {

    private class PrintNumberThread extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 100; i++) {
                    System.out.print(i + " ");
                    if (i % 10 == 0) {
                        System.out.println();
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("线程被异常中断!");
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new TestStopThread().new PrintNumberThread();
        t1.start();
        try {
           Thread.sleep(2000);
           t1.interrupt();
        } catch (Exception e) {

        }
    }

}
