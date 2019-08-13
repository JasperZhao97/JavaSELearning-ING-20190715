package com.demo.io;

import java.io.*;

/**
 * 数据字节输入输出流
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  14:39:52
 */
public class TestDataStream {

    /**
     * 读取数据
     *
     * @throws Exception
     */
    public void read() throws Exception {
        //创建数据字节输入流
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("demo20190813/src/com/demo/io/basicdata.txt"));
        int i = dataInputStream.readInt();
        double d = dataInputStream.readDouble();
        boolean b = dataInputStream.readBoolean();
        System.out.println("i=" + i);
        System.out.println("d=" + d);
        System.out.println("b=" + b);
        //关闭流
        dataInputStream.close();
    }

    /**
     * 写入数据
     *
     * @throws Exception
     */
    public void write() throws Exception {
        //创建数据字节输出流
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("demo20190813/src/com/demo/io/basicdata.txt"));
        //
        dataOutputStream.writeInt(100);
        dataOutputStream.writeDouble(50.23);
        dataOutputStream.writeBoolean(true);
        //关闭流
        dataOutputStream.close();
    }

    public static void main(String[] args) {
        TestDataStream testDataStream = new TestDataStream();
        try {
//            testDataStream.write();
            testDataStream.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
