package com.demo.practise.practise2_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月22日  20:18:28
 */
public class ChatRoomClient2 {

    private class SocketRunnable implements Runnable {

        private Socket socket;

        public SocketRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (true){
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len = inputStream.read(bytes);
                    String string = new String(bytes,0,len);
                    System.out.println(string);
                }
            } catch (Exception e) {
                System.out.println("与客户端断开链接");
            }
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.125.116",1888);
            System.out.println("成功连接聊天服务器");
            ChatRoomClient2 chatRoomClient2 = new ChatRoomClient2();
            Thread thread = new Thread(chatRoomClient2.new SocketRunnable(socket));
            thread.start();
            Scanner scanner = new Scanner(System.in);
            OutputStream outputStream = socket.getOutputStream();
            while (true) {
                String string = scanner.nextLine();
                outputStream.write(string.getBytes());
                outputStream.flush();
                if(string.equals("over")){
                    thread.interrupt();
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
