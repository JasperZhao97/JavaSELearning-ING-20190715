package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符输入输出流
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  15:41:41
 */
public class TestBufferedReaderWriter {

    /**
     * 读取数据
     *
     * @throws Exception
     */
    public void read() throws Exception {
        //创建字符输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("demo20190813/src/com/demo/io/test.txt"));
        //创建字符串变量，存储每次读取到字符串数据
        String line;
        int count = 0;
//        System.out.println(bufferedReader.readLine());
        while ((line = bufferedReader.readLine()) != null) {
            count++;
            if(count==2)System.out.println(line);
        }
        bufferedReader.close();
    }

    /**
     * 写入数据
     *
     * @throws Exception
     */
    public void write() throws Exception {
        //创建缓冲字符输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("demo20190813/src/com/demo/io/test.txt"));
        bufferedWriter.write("我爱");
        bufferedWriter.newLine();//新建行，即换行
        bufferedWriter.write("中国");
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        TestBufferedReaderWriter testBufferedReaderWriter = new TestBufferedReaderWriter();
        try {
//            testBufferedReaderWriter.write();
            testBufferedReaderWriter.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
