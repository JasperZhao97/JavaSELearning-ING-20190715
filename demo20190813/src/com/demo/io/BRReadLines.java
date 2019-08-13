package com.demo.io;

import java.io.*;

/**
 * 使用 BufferedReader 在控制台读取字符
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  14:57:45
 */
public class BRReadLines {
    public static void main(String args[]) throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
}
