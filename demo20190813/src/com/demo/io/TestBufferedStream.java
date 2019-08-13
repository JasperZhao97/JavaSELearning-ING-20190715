package com.demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 缓冲输入输出流
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  14:16:01
 */
public class TestBufferedStream {

    /**
     * 读取数据
     */
    public void read() throws Exception {
        //创建缓冲输入流，默认缓冲区大小：8k
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("demo20190813/src/com/demo/io/test.txt"));
        //定义数组，存放读取到的数据
        byte[] bytes = new byte[1024];
        //定义记录读取字节数的变量
        int len;
        //循环读取并输出文件中的数据
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //关闭流
        bufferedInputStream.close();
    }


    /**
     * 写入数据
     */
    public void write() throws Exception {
        //创建缓冲字节输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("demo20190813/src/com/demo/io/test.txt"));
        //输出数据
        bufferedOutputStream.write("你好世界\r\n".getBytes());
        bufferedOutputStream.write("Hello!\r\n".getBytes());
        bufferedOutputStream.close();
    }

    public static void main(String[] args) {
        TestBufferedStream testBufferedStream = new TestBufferedStream();
        try {
//            testBufferedStream.write();
            testBufferedStream.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
