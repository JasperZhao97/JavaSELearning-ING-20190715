package com.demo.practise.practise1_2;

import java.util.concurrent.*;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月21日 09:28:12
 */
public class MyThreadPoolExecutor {

    /**
     * 创建并返回有界线程池对象
     * @param corePoolsize
     * @return
     */
    public static ExecutorService newFixedThreadPool(int corePoolsize) {
        return new ThreadPoolExecutor(corePoolsize, corePoolsize, 0L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    /**
     * 创建并返回无界线程池对象
     * @return
     */
    public static ExecutorService newCacheThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
    }

    public static void main(String[] args) {

        class TaskRunnable extends Thread {
            private int i;

            public TaskRunnable(int i) {
                this.i = i;
            }

            @Override
            public void run() {
                System.out.println(currentThread().getName()+"  "+i);
            }
        }

        //创建线程对象
        //ExecutorService pool = MyThreadPoolExecutor.newFixedThreadPool(5);
        ExecutorService pool = MyThreadPoolExecutor.newCacheThreadPool();
        //循环添加任务
        for(int i=1; i<=100; i++) {
            pool.execute(new TaskRunnable(i));
        }
        //关闭线程池（所有任务执行结束）
        pool.shutdown();
    }

}
