package com.demo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 输出流
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月09日  16:11:44
 */
public class TestOutputStream {

    public static void main(String[] args) {
        try {
            //创建文件对象
            File file = new File("demo20190809/src/com/demo/io/test.text");
            //创建文件字节输出流
//            FileOutputStream fileOutputStream = new FileOutputStream(file);//创建输出流时，会创建一个没有数据的文件（文件不存在时）
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);//创建输出流时，会创建一个没有数据的文件（文件不存在时）//在尾部追加数据，而不是更新数据
            //写入数据到文件中
//            fileOutputStream.write("Hello World!\n你好世界".getBytes());
            fileOutputStream.write("\n这是我的第一行java代码".getBytes());
            //关闭流
            fileOutputStream.close();
            System.out.println("写入数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
