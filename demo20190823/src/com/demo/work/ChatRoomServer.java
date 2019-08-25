package com.demo.work;

import com.demo.work.pojo.User;

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

    private List<User> userList = new LinkedList<>(); //创建存储所有链接的集合

    /**
     * 处理一个链接请求的线程
     */
    private class SocketRunnable implements Runnable {

        private User user;
        private Socket socket;

        public SocketRunnable(User user) {
            this.user = user;
        }

        public SocketRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                byte[] b = new byte[10 * 1024];
                int len = in.read(b);
                String name = new String(b,0,len);
                //创建用户对象
                user = new User(name,socket);
                //添加链接到集合中
                userList.add(user);
                Socket socket = user.getSocket();
                //获得输入流

                while(true) {
                    //读取数据
                    String data = new String(b,0, len);
                    //获得用户名
                    String userName = user.getName();
                    //获得客户的IP地址
                    //System.out.println(socket.getInetAddress().getHostName()); //远程客户端
                    //System.out.println(socket.getLocalAddress().getHostName()); //本地服务器
                    String address = socket.getInetAddress().getHostName();
                    //获得当前时间
                    String currentDate = new Timestamp(System.currentTimeMillis()).toString();
                    //最终输出到客户端的数据
                    data = userName+"["+address+"]"+"  "+currentDate+"\r\n"+"  "+data;
                    //输出数据到所有客户端
                    for(User user: userList) {
                        //判断是否是当前的链接
                        if(socket==user.getSocket()) {
                            continue;
                        }
                        //获得输出流
                        OutputStream out = socket.getOutputStream();
                        out.write(data.getBytes());
                        out.flush();
                    }
                }
            } catch (SocketException e) {
                userList.remove(user);
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
