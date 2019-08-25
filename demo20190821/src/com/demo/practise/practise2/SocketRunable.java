package com.demo.practise.practise2;

import java.io.InputStream;
import java.net.Socket;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月21日  20:35:42
 */
public class SocketRunable implements Runnable {

    private Socket socket;

    public SocketRunable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            System.out.println("成员加入...");
            byte[] bytes = new byte[1024];
            int len;
            while(true){
                len = inputStream.read(bytes);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
