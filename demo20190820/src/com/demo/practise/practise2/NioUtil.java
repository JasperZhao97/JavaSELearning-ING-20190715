package com.demo.practise.practise2;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * 文件通道工具类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  19:38:26
 */
public class NioUtil {

    public static void copyFile(File inputFile,File outputFile) throws IOException {
        //创建输入文件的通道
        FileChannel fileChannel = FileChannel.open(inputFile.toPath(),
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE);
        //在目录下创建新的文件名
        String s = outputFile.getPath();
        File file = new File(s+"/"+inputFile.getName());
        System.out.println(file.getName());
        //创建输出文件的通道
        FileChannel fileChannel1 = FileChannel.open(file.toPath(),
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE);
        //将输入文件的内容复制输出文件
        fileChannel.transferTo(0,fileChannel.size(),fileChannel1);
        System.out.println("复制完毕");
    }
}
