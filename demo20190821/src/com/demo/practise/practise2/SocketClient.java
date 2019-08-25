package com.demo.practise.practise2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  20:36:37
 */
public class SocketClient {

    public static void main(String[] args) {
        try {
            //创建客户端套接字
            Socket socket = new Socket("10.23.4.52",1888);
            //获得输出流
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            //循环读取控制台写入的数据
            while (true) {
                //获取输入文本，返回字符对象
                String string = scanner.next();
                //发送数据到服务器
                outputStream.write(string.getBytes());
                //强制输出
                outputStream.flush();
                if ("over".equals(string)) {
                    //关闭流
                    outputStream.close();
                    socket.close();
                    break;
                }
            }


            InputStream inputStream = socket.getInputStream();
            System.out.println("获得服务端输入流...");
            //声明取数据的父串
            byte[] bytes = new byte[1024];
            //声明记录读取字节数的变量
            int len;
            while (true) {
                //读取数据
                len = inputStream.read(bytes);
                //将读取到的字节数组转换成字符串
                String string = new String(bytes,0,len);
                //
                if("over".equals(string)){
                    //
                    inputStream.close();
                    socket.close();
                    break;
                }
                //输出数据
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
