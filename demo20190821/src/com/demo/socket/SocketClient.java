package com.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  11:04:48
 */
public class SocketClient {

    public static void main(String[] args) {
        //创建客户端套接字对象
        try {
            Socket socket = new Socket("10.23.4.52",1888);
            //获得输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello!".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
