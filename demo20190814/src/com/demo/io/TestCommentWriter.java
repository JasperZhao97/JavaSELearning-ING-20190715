package com.demo.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 测试自定义字符输出流
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 11:35:01
 */
public class TestCommentWriter {

    public static void main(String[] args) {
        try {
            CommentWriter out = new CommentWriter(
                    new FileWriter("src/com/demo/io/test.txt"));
            out.write("你好，中软国际!!!");
            out.close();
            System.out.println("文件写入数据成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
