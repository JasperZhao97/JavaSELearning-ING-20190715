package com.demo.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  15:36:27
 */
public class MutilClientSocketClient {

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
