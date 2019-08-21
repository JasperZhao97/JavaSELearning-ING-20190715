package com.demo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * NIO
 * 对通道的基础操作
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  15:09:27
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("g:/myfile/java/新建文件夹/TestFile.java");
            FileOutputStream fileOutputStream = new FileOutputStream("G:\\myfile\\java\\TestFile.java");
            FileChannel fileChannelInput = fileInputStream.getChannel();
            FileChannel fileChannelOutput = fileOutputStream.getChannel();
            fileChannelInput.transferTo(0,fileChannelInput.size(),fileChannelOutput);
            fileChannelInput.close();
            fileInputStream.close();
            fileChannelOutput.close();
            fileChannelOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
