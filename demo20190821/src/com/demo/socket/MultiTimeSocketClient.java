package com.demo.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 可以多次向服务端发送请求的客户端程序
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  14:04:51
 */
public class MultiTimeSocketClient {

    public static void main(String[] args) {
        try {
            //创建客户端套接字
            Socket socket = new Socket("10.23.5.52",1888);
            //获得输出流
            OutputStream outputStream = socket.getOutputStream();
            /*//发送数据到服务器
            outputStream.write("你好！".getBytes());
            outputStream.flush();
            Thread.sleep(5000);
            outputStream.write("你在干嘛？".getBytes());
            outputStream.flush();*/

//            outputStream.write(System.in.toString().getBytes());
            Scanner scanner = new Scanner(System.in);
            //循环读取控制台写入的数据
            while (true) {
                //获取输入文本，返回字符对象
                String string = scanner.next();
                //发送数据到服务器
                outputStream.write(string.getBytes());
                //强制输出
                outputStream.flush();
                if("over".equals(string)){
                    //关闭流
                    outputStream.close();
                    socket.close();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
