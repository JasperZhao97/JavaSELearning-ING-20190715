package com.demo.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 非阻塞IO服务器
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月23日 10:20:38
 */
public class NIOServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(1888));
            //创建选择器
            Selector selector = Selector.open();
            //注册通道给选择器，并指定选择监听该通道事件，共有四种事件:
            //SelectionKey.OP_ACCEPT
            //selectionKey.OP_CONNECT
            //SelectionKey.OP_READ
            //SelectionKey.OP_WRITE
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器成功启动...");
            //循环选择通道、获取数据以及处理
            while(true) {
                try {
                    //选择通道
                    selector.select();
                    //System.out.println("---------------------------------------");
                    //获得“选取到通道”集合的迭代器
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    //迭代遍历通道集合
                    while (iterator.hasNext()) {
                        //获得与通道相关的key对象
                        SelectionKey selectionKey = iterator.next();
                        //删除已选key，防止重复处理；将key对象从迭代器的继承集合（selectedKeys）中移除当前的SelectionKey对象。
                        iterator.remove();
                        //判断事件
                        if (selectionKey.isAcceptable()) { //接收连接请求事件， 判断是否是第一次连接到服务器
                            //获取服务器通道
                            ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                            //获得客户端与服务器连接的通道
                            SocketChannel socketChannel = serverChannel.accept();
                            //设置通道为非阻塞模式
                            socketChannel.configureBlocking(false);
                            //返回响应数据到客户端
                            socketChannel.write(ByteBuffer.wrap("连接成功...".getBytes()));
                            //注册通过给选择器，绑定事件为可读事件
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        } else if (selectionKey.isReadable()) { //可读数据事件
                            //获得连接通道
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            //System.out.println(socketChannel.hashCode());
                            //读取通道中的数据
                            ByteBuffer buffer = ByteBuffer.allocate(10 * 1024);
                            //读取通道中数据
                            int len = socketChannel.read(buffer);
                            //提取缓冲区中的字节数据
                            byte[] b = buffer.array();
                            //输出客户端传递过来数据
                            System.out.println(new String(b));
                            socketChannel.write(ByteBuffer.wrap("OK...".getBytes()));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
