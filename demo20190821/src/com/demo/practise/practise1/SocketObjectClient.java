package com.demo.practise.practise1;

import com.demo.practise.practise1.pojo.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  19:26:20
 */
public class SocketObjectClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.23.4.52",1888);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(new Student("张三",17));
            objectOutputStream.writeObject(new Student("李四",18));
            objectOutputStream.writeObject(new Student("王麻子",19));
            objectOutputStream.flush();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
