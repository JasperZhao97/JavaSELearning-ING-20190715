package com.demo.test;

import java.io.File;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月26日  10:24:20
 */
public class test1 {

    public static void main(String[] args) {

        /*//文件名称分隔符
        System.out.println(File.separator);//输出结果为一个string类型的\*/

        /*ok:for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(j==3)break ok;
                System.out.println(i+","+j);
            }
        }*/

        int[][] a = new int[3][4];
        System.out.println(a.length);
    }
}
