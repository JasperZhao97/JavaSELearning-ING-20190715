package com.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 输入流
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月09日  16:30:47
 */
public class TestInputStream {

    public static void main(String[] args) {
        try {
            //创建文件对象
            File file = new File("demo20190809/src/com/demo/io/test.text");
            //创建文件字节输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            //定义缓存数据的数组
            byte[] bytes = new byte[100*1024];
            //定义记录读取到字节数据的变量
            int len;
            //循环读取文件中的数据
            while((len=fileInputStream.read(bytes))!=-1){
                String string = new String(bytes,0,len);
                System.out.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
