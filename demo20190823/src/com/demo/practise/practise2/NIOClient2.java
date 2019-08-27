package com.demo.practise.practise2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 非阻塞客户端
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月25日  15:40:28
 */
public class NIOClient2 {

    /**
     * 负责读取数据的线程
     */
    private class ReadRunnable implements Runnable {

        private Selector selector;

        public ReadRunnable(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                //以轮询的方式访问选择器
                while(true) {
                    //选择通道
                    selector.select();
                    //获得选择到通道的集合，返回迭代器
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    //迭代遍历集合
                    while(iterator.hasNext()) {
                        //获得通道信息相关的对象
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        //判断事件
                        if(selectionKey.isConnectable()) { //已连接（连接就绪）事件
                            //获得通道（该通道连接客户端与服务器）
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            //判断连接是否正在连接
                            if(channel.isConnectionPending()) {
                                //完成连接
                                channel.finishConnect();
                            }
                            //将选择器的监听事件修改为可读事件
                            channel.register(selector, SelectionKey.OP_READ);
                        } else if(selectionKey.isReadable()) { //可读事件
                            //获得通道
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            //读取服务器响应数据
                            ByteBuffer buffer = ByteBuffer.allocate(10*1024);
                            int len = channel.read(buffer);
                            String data = new String(buffer.array(), 0, len);
                            //输出服务器响应数据
                            System.out.println(data);
                            //发送数据到服务器
                            //channel.write(ByteBuffer.wrap("Hello!".getBytes()));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            //创建Socket通道
            SocketChannel socketChannel = SocketChannel.open();
            //设置通道为非阻塞模式
            socketChannel.configureBlocking(false);
            //连接服务器
            socketChannel.connect(new InetSocketAddress("192.168.0.112", 1888));
            //创建选择器
            Selector selector = Selector.open();
            //通道注册给选择器, 绑定监听事件为“已连接（连接继续）”事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            //创建读取数据的线程对象
            Thread thread = new Thread(new NIOClient2().new ReadRunnable(selector) {
            });
            //启动线程
            thread.start();

            //创建文件扫描器
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //读取控制台输入的数据
                String data = scanner.nextLine();
                //发送数据到服务器
                socketChannel.write(ByteBuffer.wrap(data.getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
