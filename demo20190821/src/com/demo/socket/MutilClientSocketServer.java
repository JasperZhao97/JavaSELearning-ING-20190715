package com.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  15:35:56
 */
public class MutilClientSocketServer {

    private class SocketRunable implements Runnable{

        private Socket socket;

        public SocketRunable(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            MutilClientSocketServer mutilClientSocketServer = new MutilClientSocketServer();
            //创建服务器套接字
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("启动服务器成功...");
            //循环等待客户端请求
            while (true) {
                Socket socket = serverSocket.accept();
                //开启处理客户端请求的线程
                Thread thread = new Thread(mutilClientSocketServer.new SocketRunable(socket));
                //自动线程
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
