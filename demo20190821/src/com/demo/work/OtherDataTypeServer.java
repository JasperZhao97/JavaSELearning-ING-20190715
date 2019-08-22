package com.demo.work;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 套接字传递基本数据类型与对象型数据的服务器
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月22日 09:32:57
 */
public class OtherDataTypeServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1888);
            Socket socket = serverSocket.accept();
            //基本数据类型输入流
            /*DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readInt());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());*/
            /*//对象输入流
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Student student = (Student) in.readObject();
            System.out.println(student.getName()+", "+student.getGender()+", "+student.getAge());*/
            //使用通道读取数据,
            /*SocketChannel channel = socket.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer); //空指针异常，未获取到通道
            byte[] b = buffer.array();
            System.out.println("内容长度: "+b.length);
            System.out.println(new String(b));*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
