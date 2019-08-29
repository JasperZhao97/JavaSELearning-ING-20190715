package com.demo.test;

import java.io.*;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月29日  10:50:32
 */
public class Tset1 {

    public static void main(String[] args) throws Exception {

        //虽然某些字节字符的构造方法的形参类型为InputStream或者reader，但是传入的参数也可以为他们的子类
        FileInputStream fileInputStream = new FileInputStream("");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        DataInputStream dataInputStream1 = new DataInputStream(bufferedInputStream);

    }
}
