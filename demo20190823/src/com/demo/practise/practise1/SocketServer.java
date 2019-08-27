package com.demo.practise.practise1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务器
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月25日  14:06:02
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
            byte[] bytes1 = new byte[1024];
            int len =  in.read(bytes1);
            String string = new String(bytes1,0,len);
            //获得客户端需要上传的文件
            File file = new File(string);
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getName()));
            //获得文件名和长度
            byte[] bytes = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
                fileOutputStream.flush();
            }
            System.out.println("客户端成功上传文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
