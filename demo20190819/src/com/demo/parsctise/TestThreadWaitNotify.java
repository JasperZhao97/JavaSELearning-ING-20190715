package com.demo.parsctise;


/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月19日  16:59:03
 */
public class TestThreadWaitNotify {

    private class Account {

        private Integer amount = 0;


        public void deposit(int inAmount) {
            synchronized (this) {
                this.amount = this.amount + inAmount;
                System.out.println("存入：￥" + inAmount + "取出：￥0" + " 余额：￥" + amount);
                notify();
            }
        }

        public synchronized void withDraw(int outAmount) {
            try {
                if (outAmount > amount) {
                    wait();
                } else {
                    amount = amount - outAmount;
                    System.out.println("存入：￥0" + "取出：￥" + outAmount + " 余额：￥" + amount);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Integer getAmount() {
            return this.amount;
        }
    }

    private class DepositRunnable implements Runnable {

        private Account account;

        public DepositRunnable(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                //生成随机数为存入的金额
                int amount = (int) (Math.random() * 500);
                account.deposit(amount);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class withDrawRunnable implements Runnable {

        private Account account;

        public withDrawRunnable(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                //生成随机数为取出的金额
                int amount = (int) (Math.random() * 500);
                account.withDraw(amount);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThreadWaitNotify ttwn = new TestThreadWaitNotify();
        Account account = ttwn.new Account();
        Thread depositThread = new Thread(ttwn.new DepositRunnable(account));
        Thread withdrawThread = new Thread(ttwn.new withDrawRunnable(account));
        depositThread.start();
        withdrawThread.start();
    }
}
