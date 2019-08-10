package com.demo.practise.practise1;

import java.io.FileNotFoundException;

/**
 * 文件测试类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月10日  16:47:45
 */
public class TestFile {

    public static void main(String[] args) {
        try {
            FileService fileService = new FileService();
            System.out.println("已复制所有图片到默认目录");
            fileService.methodCopy("g:/myfile");
            System.out.println("已复制所有图片到指定目录");
            fileService.methodCopy("g:/myfile","g:/myfile/picture2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
