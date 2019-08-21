package com.demo.practise.practise1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  19:15:23
 */
public class SocketBasicServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("服务器启动...");
            Socket socket = serverSocket.accept();
            System.out.println("成功链接客户端...");
            //得到输入流
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            Double num = dataInputStream.readDouble();
            System.out.println("Double类型为："+num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
