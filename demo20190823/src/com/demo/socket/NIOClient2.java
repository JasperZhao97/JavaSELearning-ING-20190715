package com.demo.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 非阻塞客户端
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月23日 10:20:53
 */
public class NIOClient2 {

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
            //以轮询的方式访问选择器
            while(true) {
                //选择通道
                selector.select();
                //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
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

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
