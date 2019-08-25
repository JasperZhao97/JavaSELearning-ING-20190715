package com.demo.practise.practise1_2;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * 使用NIO复制文件
 *
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月21日 09:58:37
 */
public class CopyFileByNio {

    public static void main(String[] args) {
        try {
            //创建准备复制的资源文件对象
            File sourceFile = new File("C:\\Users\\Administrator\\Desktop\\堆栈.png");
            //创建存放文件的目录对象
            File targetDir = new File("D:/myfile");
            //判断目录是否存在
            if (!targetDir.exists()) {
                targetDir.mkdir();
            }
            //创建文件处理通道对象
            FileChannel in = FileChannel.open(sourceFile.toPath(), StandardOpenOption.READ);
            FileChannel out = FileChannel.open(new File(targetDir, sourceFile.getName())
                    .toPath(), StandardOpenOption.CREATE ,StandardOpenOption.WRITE);
            //复制文件
            in.transferTo(0, in.size(), out);
            //关闭通道
            in.close();
            out.close();
            System.out.println("复制文件完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
