package com.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  11:04:23
 */
public class SocketServer {

    public static void main(String[] args) {
        try {
            //创建服务器套接字
            ServerSocket serverSocket = new ServerSocket(1888);
            //服务器启动完毕
            System.out.println("成功启动服务器...");
            //等待客户端链接
            Socket socket = serverSocket.accept();
            System.out.println("获得客户端链接请求，客户端与服务成功链接...");
            //获得输入流
            InputStream in = socket.getInputStream();
            System.out.println("获得客户发送过来的数据...");
            //定义数组，用于读取到的数据
            byte[] bytes = new byte[1024];
            //声明记录读取字节数的变量
            int len;
            //读取数据
            len = in.read(bytes);
            //输出数据
            System.out.println(new String(bytes,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
