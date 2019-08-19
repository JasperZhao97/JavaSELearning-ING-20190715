package com.demo.Test;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月19日  16:04:29
 */
public class TestMy {


    private class Account {

        private Integer amount = 50;

        public Account(Integer amount) {
            this.amount = amount;
        }

        public void deposit(int inAmount) {
            try {
                synchronized (this) {
                    int amount = this.amount;
                    Thread.sleep(50);
                    this.amount = amount + inAmount;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Integer getAmount(){
            return this.amount;
        }
    }


    private class DepositThread implements Runnable {

        private Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.deposit(1);
        }
    }

    public static void main(String[] args) {
        try {
            TestMy testMy = new TestMy();
            Account account = testMy.new Account(0);
            ThreadGroup threadGroup = new ThreadGroup("accountThreadGroup");
            for (int i = 0;i<100;i++){
                Thread thread = new Thread(threadGroup,testMy.new DepositThread(account));
                thread.start();
            }
            //等待所有Thread执行结束
            while(threadGroup.activeCount()>0){
                Thread.sleep(100);
            }
            System.out.println("账号余额："+account.getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
