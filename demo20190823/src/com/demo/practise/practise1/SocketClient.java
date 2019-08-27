package com.demo.practise.practise1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket客户端
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月25日  14:06:02
 */
public class SocketClient {

    public static void main(String[] args) {
        //创建客户端套接字对象
        try {
            Socket socket = new Socket("192.168.0.112",1888);
            //获得输出流
            OutputStream outputStream = socket.getOutputStream();
            //需要上传的文件
            outputStream.write("g:/myfile".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
