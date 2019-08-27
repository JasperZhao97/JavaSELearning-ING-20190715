package com.demo.practise.practise2;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月27日  09:11:05
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用Socket模拟HTTP服务器
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月26日  19:11:05
 */
public class HttpServer {

    private static String root = "demo20190826/src/com/demo/webcontent";
    private static Map<String, String> mimes;

    static {
        mimes = new HashMap<>();
        mimes.put(".html", "text/html");
        mimes.put(".jpg", "image/jpeg");
        mimes.put(".png", "image/png");
        mimes.put(".gif", "image/gif");
        mimes.put(".txt", "text/plain");
        mimes.put(".ico", "image/x-icon");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        final String CRLF = "\r\n";
       Server.server("demo20190826/src/com/demo/webcontent",CRLF,mimes);
    }

}