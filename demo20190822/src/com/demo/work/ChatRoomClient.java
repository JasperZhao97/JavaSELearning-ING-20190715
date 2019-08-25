package com.demo.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月22日 10:29:52
 */
public class ChatRoomClient {

    /**
     * 读取并输出返回数据的线程
     */
    private class SocketRunnage implements Runnable {

        private Socket socket;

        public SocketRunnage(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    //获得输入流
                    InputStream in = socket.getInputStream();
                    //读取数据
                    byte[] b = new byte[10*1024];
                    int len  = in.read(b);
                    String data = new String(b, 0, len);
                    //控制台输出数据
                    System.out.println(data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            //连接服务器
            Socket socket = new Socket("10.23.0.125", 1888);
            System.out.println("成功连接聊天服务器...");
            //创建并开启处理连接任务线程
            ChatRoomClient chatRoomClient = new ChatRoomClient();
            Thread thread = new Thread(chatRoomClient.new SocketRunnage(socket));
            thread.start();
            //创建文本扫描器
            Scanner scanner = new Scanner(System.in);
            //获得输出流
            OutputStream out = socket.getOutputStream();
            System.out.println("请输入用户名: ");
            //循环读取控制台输入数据
            while(true) {
                //读取输入数据
                String data = scanner.nextLine();
                //发送数据
                out.write(data.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
