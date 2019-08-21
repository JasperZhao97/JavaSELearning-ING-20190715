package com.demo.practise.practise1;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程池
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  20:22:22
 */
public class MyThreadPool {

    private List<MyExecutors> list = new ArrayList<MyExecutors>();
    private int count;

    //初始化线程池的线程数
    public MyThreadPool(int i){
        this.count = i;
        for(int j = i;j>0;j--){
            MyExecutors myExecutors = new MyExecutors();
            this.list.add(myExecutors);
            myExecutors.start();
        }
        System.out.println(list.size());
    }

    public void excute(Thread thread) {
        for(MyExecutors myExecutors:this.list){
            if(!myExecutors.isRunFlag()){

            }
        }
    }
}
