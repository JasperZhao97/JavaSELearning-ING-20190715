package com.demo.practise.practise1;

import com.demo.practise.practise1.pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接受对象的服务器
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  20:00:52
 */
public class SocketObjectServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1888);
            System.out.println("服务器启动...");
            Socket socket = serverSocket.accept();
            System.out.println("成功链接客户端...");
            //得到输入流
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object object = new Object();
            while((object=objectInputStream.readObject())!=null){
                Student student = (Student) object;
                System.out.println("学生名字："+student.getName()+"学生年龄："+student.getAge());
            }
        } catch (Exception e) {
            System.out.println("客户端链接断开");
        }
    }
}
