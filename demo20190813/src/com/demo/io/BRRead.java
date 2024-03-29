package com.demo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用 BufferedReader 在控制台读取字符
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  14:36:57
 */

public class BRRead {
    public static void main(String args[]) throws IOException
    {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        System.out.println("Enter characters, 'q' to quit.");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while(c != 'q');

    }
}