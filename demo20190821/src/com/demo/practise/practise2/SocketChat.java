package com.demo.practise.practise2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  20:59:08
 */
public class SocketChat {

    public static void main(String[] args) {
        try {
            //创建服务器套接字
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("启动聊天室成功...");
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
