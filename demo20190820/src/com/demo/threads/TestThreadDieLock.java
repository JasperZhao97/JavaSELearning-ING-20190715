package com.demo.threads;

import jdk.nashorn.internal.runtime.ECMAException;

/**
 * 线程死锁
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月20日 09:48:02
 */
public class TestThreadDieLock {

    /**
     * 访问资源的接口
     */
    private interface IResource {
        public void method();
    }

    /**
     * 资源类1
     */
    private class Resource1 implements IResource {

        private Resource2 r2;

        public void setR2(Resource2 r2) {
            this.r2 = r2;
        }

        public synchronized void method() {
            try {
                System.out.println("访问资源对象1!");
                Thread.sleep(1000);
                r2.method();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 资源类2
     */
    private class Resource2 implements IResource {

        private Resource1 r1;

        public void setR1(Resource1 r1) {
            this.r1 = r1;
        }

        public synchronized void method() {
            try {
                System.out.println("访问资源对象2!");
                Thread.sleep(1000);
                r1.method();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 访问资源对象的线程任务类
     */
    private class ResourceRunnable implements Runnable {

        private IResource iresource; //声明访问资源的接口变量

        public ResourceRunnable(IResource iresource) {
            this.iresource = iresource;
        }

        @Override
        public void run() {
            iresource.method();
        }
    }

    public static void main(String[] args) {
        TestThreadDieLock ttdl = new TestThreadDieLock();
        //创建两个资源对象
        Resource1 r1 = ttdl.new Resource1();
        Resource2 r2 = ttdl.new Resource2();
        r1.setR2(r2);
        r2.setR1(r1);
        //创建线程对象
        Thread t1 = new Thread(ttdl.new ResourceRunnable(r1));
        Thread t2 = new Thread(ttdl.new ResourceRunnable(r2));
        //启动线程
        t1.start();
        t2.start();
    }

}
