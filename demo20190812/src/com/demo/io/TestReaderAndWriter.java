package com.demo.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月12日  15:51:43
 */
public class TestReaderAndWriter {

    /**
     * 读取数据
     * @param path
     * @throws Exception
     */
    public void read(String path) throws Exception {
        //创建文件字符输入流
        FileReader fileReader = new FileReader(path);
        //定义缓存字符数据的字符数组
        char[] chars = new char[1024*1024];
        //定义记录读取到字符数的变量
        int len;
        //循环读取数据
        while((len=fileReader.read(chars))!=-1) {
            System.out.println(new String(chars,0,len));
        }
        fileReader.close();
    }

    /**
     * 写文件
     * @param path
     * @param content
     * @throws Exception
     */
    public void write(String path,String content) throws Exception{
        //创建文件字符输出流
        FileWriter fileWriter = new FileWriter(path,true);
        //输出字符串数据
        fileWriter.write("#"+new Timestamp(System.currentTimeMillis()) +"\r\n");
        fileWriter.append(content);
        fileWriter.append("\r\n");
        //关闭流
        fileWriter.close();
    }

    public static void main(String[] args) {
        TestReaderAndWriter testReaderAndWriter = new TestReaderAndWriter();
        try {
            //testReaderAndWriter.write("demo20190812/src/com/demo/io/test.txt","你好中软国际！");
            testReaderAndWriter.read("demo20190812/src/com/demo/io/test.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
