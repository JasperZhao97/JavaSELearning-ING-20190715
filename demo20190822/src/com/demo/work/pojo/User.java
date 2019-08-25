package com.demo.work.pojo;

import java.io.Serializable;
import java.net.Socket;

/**
 * 客户封装类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月23日 09:30:30
 */
public class User implements Serializable {

    private String name; //姓名
    private Socket socket; //链接

    public User() {
    }

    public User(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
