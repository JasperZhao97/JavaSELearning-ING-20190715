package com.demo.threads;

/**
 * 测试应用守护线程
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月19日 11:26:40
 */
public class TestDaemonThread {

    /**
     * 守护线程
     */
    private class DaemonThread extends Thread {

        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println("正在监控中...");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class PrintNumber extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 100; i++) {
                    System.out.print(i+" ");
                    if(i%10==0) {
                        System.out.println();
                    }
                    sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestDaemonThread tdt = new TestDaemonThread();
        Thread t1 = tdt.new DaemonThread();
        Thread t2 = tdt.new PrintNumber();
        //将线程t1标记为守护线程
        t1.setDaemon(true);
        t1.start();
        t2.start();
    }

}
