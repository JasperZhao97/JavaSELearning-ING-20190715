package com.demo.work;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * 套接字传递基本数据类型与对象型数据的客户端
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月22日 09:33:17
 */
public class OtherDataTypeClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.23.0.125", 1888);
            //基本数据类型输出流
            /*DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeInt(100);
            out.writeDouble(100.25);
            out.writeUTF("你好!");
            out.writeUTF("How are you!");
            out.flush();*/
            //对象输出流
            /*ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(new Student("张宇","男", 21));
            out.flush();*/
            //Channel通道传输数据
            /*SocketChannel channel = socket.getChannel();
            System.out.println(channel); 、
            channel.write(ByteBuffer.wrap("你好!".getBytes())); //空指针异常，未获取到通道 */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
