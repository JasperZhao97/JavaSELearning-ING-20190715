package com.demo.practise.practise2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 类似聊天室的功能
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  20:26:29
 */
public class SocketChatRoom {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("聊天室开启...");
            while (true) {
                Socket socket = serverSocket.accept();
                Thread  thread = new Thread(new SocketRunable(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
