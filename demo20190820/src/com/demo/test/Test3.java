package com.demo.test;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月20日  17:17:12
 */
public class Test3 {

    public static void main(String[] args) {
        try {
            //创建文件对象
            File file = new File("demo20190820/src/com/demo/test/test.txt");
            //创建文件处理的通道对象
            FileChannel channel = FileChannel.open(file.toPath(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.READ,
                    StandardOpenOption.WRITE);
            //写入数据到文件
            channel.write(ByteBuffer.wrap(("Hello World\r\n").getBytes()));
            channel.write(ByteBuffer.wrap(("你好 中软国际").getBytes()));

            //读取文件数据
            channel.position(0);//切换读写
            //创建缓冲区对象
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
            //读取数据
            int count = channel.read(byteBuffer);
            //将标记还原成0
            byteBuffer.position(0);
            //创建读取数据的数组
            byte[] bytes = new byte[count];
            //提取缓冲区中的数据
            byteBuffer.get(bytes);
            //输出数据
            System.out.println(new String(bytes));
            //关闭文件处理通道
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
