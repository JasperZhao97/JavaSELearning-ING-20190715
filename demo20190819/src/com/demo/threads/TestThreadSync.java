package com.demo.threads;

/**
 * 线程同步
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月19日 16:03:11
 */
public class TestThreadSync {

    /**
     * 账户类
     */
    private class Account {

        private Integer amount = 0; //金额

        /**
         * 存款
         * @param inAmount
         */
        /*public synchronized void deposit(int inAmount) {
            try {
                int amount = this.amount;
                Thread.sleep(6);
                this.amount = amount+inAmount;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        public void deposit(int inAmount) {
            try {
                synchronized (this) {
                    int amount = this.amount;
                    Thread.sleep(6);
                    this.amount = amount + inAmount;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 获得余额
         * @return
         */
        public Integer getAmount() {
            return  this.amount;
        }

    }

    /**
     * 存款线程
     */
    private class DepositRunable implements Runnable {

        private Account account; //声明账户类型变量

        public DepositRunable(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.deposit(1);
        }
    }


    public static void main(String[] args) {
        try {
            TestThreadSync tts = new TestThreadSync();
            //创建资源对象
            Account account = tts.new Account();
            //创建线程组
            ThreadGroup group = new ThreadGroup("accountThreadGroup");
            //循环创建线程并添加到线程组中
            for (int i = 0; i < 100; i++) {
                Thread t = new Thread(group, tts.new DepositRunable(account));
                t.start();
            }
            //等待线程组所有线程执行结束
            while (group.activeCount() > 0) {
                Thread.sleep(100);
            }
            //输出账户余额
            System.out.println("账户余额: "+account.getAmount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
