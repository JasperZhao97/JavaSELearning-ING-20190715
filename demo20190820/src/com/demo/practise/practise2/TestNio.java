package com.demo.practise.practise2;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  19:33:02
 */
public class TestNio {

    public static void main(String[] args) {
        try {
            NioUtil.copyFile(new File("demo20190820/src/com/demo/practise/practise2/test.txt"),new File("g:/myfile"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
