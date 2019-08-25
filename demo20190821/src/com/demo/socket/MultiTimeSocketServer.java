package com.demo.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 可以多次处理客户端请求的服务器程序
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  14:05:48
 */
public class MultiTimeSocketServer {

    public static void main(String[] args) {
        try {
            //创建服务器套接字
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("启动服务器成功...");
            //等待客户端的链接请求
            Socket socket = serverSocket.accept();
            System.out.println("客户端链接成功...");
            //获得输入流
            InputStream inputStream = socket.getInputStream();
            System.out.println("获得客户端输入流...");
            //声明取数据的祖父串
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
//            //循环读取数据
//            while((string = bufferedReader.readLine())!=null){
//                System.out.println(string);
//            }
        } catch (Exception e) {
            System.out.println("客户端断开链接");;
        }
    }
}
