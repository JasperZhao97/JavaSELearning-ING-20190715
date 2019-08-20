package com.demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

/**
 * 测试应用非阻塞IO
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月20日 15:30:51
 */
public class TestNIO {

    public static void main(String[] args) {
        try {
            //创建文件对象
            File file = new File("src/com/demo/nio/test.txt");
            //创建文件处理通道, 权限：创建新文件（文件不存在），读取、写入
            FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.CREATE,
                    StandardOpenOption.READ, StandardOpenOption.WRITE);
            //写入数据到文件中
            channel.write(ByteBuffer.wrap("Hello World!\r\n".getBytes()));
            channel.write(ByteBuffer.wrap("你好 中软国际!".getBytes()));

            //读取文件文件数据
            channel.position(0); //切换读写
            //创建缓冲区对象
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
            //读取数据
            int count = channel.read(byteBuffer);
            System.out.println(byteBuffer);
            //将标记的位置还原成0
            //byteBuffer.position(0);
            //byteBuffer.flip();
            byteBuffer.clear();
            System.out.println(byteBuffer);
            //创建封装读取数据的数组
            byte[] b = new byte[count];
            //提取缓冲区中的数据
            byteBuffer.get(b);
            //输出数据
            System.out.println(new String(b));
            //关闭文件处理通道
            channel.close();
            System.out.println("程序执行完毕!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
