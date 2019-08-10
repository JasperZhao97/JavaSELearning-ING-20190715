package com.demo.file;

import java.io.File;

/**
 * ioFile类测试
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月09日  10:46:48
 */
public class MyTestFile {

    public static void getFile(File file1) {
        //获得file1文件下的所有文件
        File[] files1 = file1.listFiles();
        //循环得到的文件
        for(File file2:files1){
            if (file2.isDirectory()){
                System.out.print("这是目录：");
                System.out.println(""+file2.getPath());
                getFile(file2);
            }else{
                System.out.println(file2.getPath());
            }
        }
    }

    public static void main(String[] args) {
        //获得初始文件
//        File file = new File("g:/myfile/");
//        getFile(file);
    }
}
