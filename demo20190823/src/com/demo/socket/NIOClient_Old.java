package com.demo.socket;

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
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月23日 10:20:53
 */
public class NIOClient_Old {

    private class ReadRunnable implements Runnable {

        private Selector selector;
        //private SocketChannel socketChannel;

        public ReadRunnable(Selector selector) {
            this.selector = selector;
            //this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            try {
                //以轮询的方式访问选择器
                while(true) {
                    //选择通道
                    selector.select();
                    //获得通道，并获得迭代器
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    //迭代遍历集合
                    while(iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        iterator.remove();
                        if(selectionKey.isConnectable()) {
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            //判断是否正在连接
                            if(channel.isConnectionPending()) {
                                //完成连接
                                channel.finishConnect();
                            }
                            // 向服务器发送消息
                            //channel.write(ByteBuffer.wrap(new String("客户端1确认连接!").getBytes()));
                            // 连接成功后，注册接收服务器消息的事件
                            channel.register(selector, SelectionKey.OP_READ);
                        } else if(selectionKey.isReadable()) {
                            //获得连接通道
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            //读取通道中的数据
                            ByteBuffer buffer = ByteBuffer.allocate(10*1024);
                            //读取通道中数据
                            int len = channel.read(buffer);
                            //提取缓冲区中的字节数据
                            byte[] b = buffer.array();
                            //输出客户端传递过来数据
                            System.out.println(new String(b));
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
            socketChannel.connect(new InetSocketAddress("10.23.0.125", 1888));
            //创建选择器
            Selector selector = Selector.open();
            //通道注册给选择器, 绑定监听事件为“已连接（连接继续）”事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            //创建线程
            NIOClient_Old client = new NIOClient_Old();
            Thread thread = new Thread(client.new ReadRunnable(selector));
            thread.start();

            //控制台输入数据并写入通道
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String data = scanner.nextLine();
                socketChannel.write(ByteBuffer.wrap(data.getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
