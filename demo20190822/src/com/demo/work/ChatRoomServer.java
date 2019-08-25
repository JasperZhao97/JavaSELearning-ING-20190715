package com.demo.work;

import com.demo.work.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月22日 10:28:39
 */
public class ChatRoomServer {

    private List<User> socketList = new LinkedList<>(); //创建存储所有链接的集合

    /**
     * 处理一个链接请求的线程
     */
    private class SocketRunnable implements Runnable {

        private Socket socket; //链接客户端的套接字
        private User user; //用户

        public SocketRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                //获得输入流
                InputStream in = socket.getInputStream();
                //创建存储每次读取到数据数组
                byte[] b = new byte[10 * 1024];
                //获取用户名数据
                int len = in.read(b);
                String name = new String(b, 0, len);
                //创建用户对象
                user = new User(name, socket);
                //添加用户到集合中
                socketList.add(user);
                //循环处理客户端请求
                while(true) {
                    //读取数据
                    len = in.read(b);
                    String data = new String(b,0, len);
                    //获得客户的IP地址
                    //System.out.println(socket.getInetAddress().getHostName()); //远程客户端
                    //System.out.println(socket.getLocalAddress().getHostName()); //本地服务器
                    String address = socket.getInetAddress().getHostName();
                    //获得当前时间
                    String currentDate = new Timestamp(System.currentTimeMillis()).toString();
                    //最终输出到客户端的数据
                    data = name+"["+address+"]  "+currentDate+"\r\n"+"  "+data;
                    //输出数据到所有客户端
                    for(User user: socketList) {
                        //判断是否是当前的用户
                        if(user==this.user) {
                            continue;
                        }
                        //获得输出流
                        OutputStream out = user.getSocket().getOutputStream();
                        out.write(data.getBytes());
                        out.flush();
                    }
                }
            } catch (SocketException e) {
                socketList.remove(user);
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ChatRoomServer chatRoomServer = new ChatRoomServer();
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("成功启动聊天服务器...");
            while(true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(chatRoomServer.new SocketRunnable(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
