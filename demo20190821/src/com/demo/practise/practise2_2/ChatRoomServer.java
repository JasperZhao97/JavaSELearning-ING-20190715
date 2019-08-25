package com.demo.practise.practise2_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * 服务器类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月22日  19:35:36
 */
public class ChatRoomServer {

    private List<Socket> socketLists = new LinkedList<>();

    private class SocketRunnable implements Runnable {

        private Socket socket;

        public SocketRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socketLists.add(socket);
                InputStream inputStream = socket.getInputStream();
                while (true) {
                    byte[] bytes = new byte[1024];
                    int count = inputStream.read(bytes);
                    String string = new String(bytes, 0, count);
                    if (string.equals("over")){
                        System.out.println(socket.getInetAddress()+"断开链接");
                        for(Socket socket2:socketLists){
                            if(socket2.equals(socket)){
                                socketLists.remove(socket);
                            }
                        }
                        for(Socket socket2:socketLists){
                            OutputStream outputStream = socket2.getOutputStream();
                            outputStream.write((socket.getInetAddress()+"已经断开链接").getBytes());
                            outputStream.flush();
                        }
                        inputStream.close();
                        socket.close();
                        break;
                    }
                    String currentDate = new Timestamp(System.currentTimeMillis()).toString();
                    string = socket.getInetAddress().getHostName() +" "+ currentDate + "\r\n" + string;
                    for (Socket socket1 : socketLists) {
                        if (socket1 == this.socket) {
                            continue;
                        }
                        OutputStream outputStream = socket1.getOutputStream();
                        outputStream.write(string.getBytes());
                        outputStream.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ChatRoomServer chatRoomServer = new ChatRoomServer();
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("服务器已经打开");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("用户：" + socket.getInetAddress().getHostName() + "" + "连接");
                Thread thread = new Thread(chatRoomServer.new SocketRunnable(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
