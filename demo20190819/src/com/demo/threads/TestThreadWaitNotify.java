package com.demo.threads;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月19日 16:58:16
 */
public class TestThreadWaitNotify {

    /**
     * 账户类
     */
    private class Account {

        private Integer amount = 0; //金额

        /**
         * 存款
         *
         * @param inAmount
         */
        public synchronized void deposit(int inAmount) {
            amount = amount + inAmount;
            System.out.println("存入:￥" + inAmount + "\t\t\t取出:￥0\t\t\t余额:￥" + amount);
            notify();
        }

        /**
         * 取款
         *
         * @param outAmount
         */
        public synchronized void withdraw(int outAmount) {
            try {
                if (outAmount > amount) {
                    wait();
                } else {
                    amount = amount - outAmount;
                    System.out.println("存入:￥0\t\t\t取出:￥" + outAmount + "\t\t\t余额:￥" + amount);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 获得余额
         *
         * @return
         */
        public Integer getAmount() {
            return this.amount;
        }

    }

    /**
     * 存款线程
     */
    private class DepositRunnable implements Runnable {

        public Account account; //账户类

        public DepositRunnable(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    //生成随机数为存入的金额
                    int amount = (int) (Math.random() * 500);
                    account.deposit(amount);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 取款线程
     */
    private class WithdrawRunable implements Runnable {

        public Account account; //账户类

        public WithdrawRunable(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    //生成随机数为存入的金额
                    int amount = (int) (Math.random() * 500);
                    account.withdraw(amount);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThreadWaitNotify ttwn = new TestThreadWaitNotify();
        Account account = ttwn.new Account();
        Thread depositThread = new Thread(ttwn.new DepositRunnable(account));
        Thread withdrawThread = new Thread(ttwn.new WithdrawRunable(account));
        depositThread.start();
        withdrawThread.start();
    }

}
