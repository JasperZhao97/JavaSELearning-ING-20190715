package com.demo.practise.practise1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket客户端
 * 可以传输基本数据类型
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  19:15:42
 */
public class SocketBasicClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.23.4.52",1888);
            //创建字节输出流
            OutputStream outputStream = socket.getOutputStream();
            //创建基本数据类型的流
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            dataOutputStream.writeByte(2);
//            dataOutputStream.writeShort(3);
//            dataOutputStream.writeInt(100);
//            dataOutputStream.writeLong(8888888);
//            dataOutputStream.writeFloat(35);
            dataOutputStream.writeDouble(68.0);
            dataOutputStream.flush();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
