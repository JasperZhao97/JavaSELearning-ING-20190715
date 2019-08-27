package com.demo.practise.practise2_2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月26日 09:39:11
 */
public class ChatRoomClient {

    /**
     * 读取通道数据的线程任务类
     */
    private class ReadRunnable implements Runnable {

        private Selector selector; //选择器

        public ReadRunnable(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
           try {
               //循环选择通道
               while(true) {
                   //选择通道并处理
                   selector.select();
                   //System.out.println("-------------------------------------------------");
                   //获得通道集合的迭代器
                   Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                   //迭代遍历通道集合
                   while(iterator.hasNext()) {
                       //获得选择通道的key对象
                       SelectionKey selectionKey = iterator.next();
                       //移除当前通道的key
                       iterator.remove();
                       //判断触发事件类型
                       if(selectionKey.isConnectable()) { //可连接事件
                           //获得客户端与服务器连接通道
                           SocketChannel channel = (SocketChannel) selectionKey.channel();
                           //判断是否正在连接
                           if(channel.isConnectionPending()) {
                               //等待完成连接
                               channel.finishConnect();
                           }
                           //通道注册给选择器并绑定可读事件
                           channel.register(selector, SelectionKey.OP_READ);
                           System.out.println("连接成功!");
                       } else if(selectionKey.isReadable()) {  //可读事件
                           SocketChannel channel = (SocketChannel) selectionKey.channel();
                           //读取数据
                           ByteBuffer buffer = ByteBuffer.allocate(10*1024);
                           int len = channel.read(buffer);
                           String data = new String(buffer.array());
                           System.out.println(data);
                       }
                   }
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }

    public ChatRoomClient() throws IOException {
        init();
    }

    /**
     * 初始化
     */
    public void init() throws IOException {
        //创建客户端通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置通过阻塞模式
        socketChannel.configureBlocking(false);
        //连接服务器
        socketChannel.connect(new InetSocketAddress("10.23.0.125", 1888));
        //创建选择器
        Selector selector = Selector.open();
        //通道注册给选择器并绑定"可连接"事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        //创建线程对象
        Thread thread = new Thread(new ReadRunnable(selector));
        //启动线程
        thread.start();

        //创建文本扫描器
        Scanner scanner = new Scanner(System.in);
        //循环写入数据
        while(true) {
            //读取一行数据
            String data = scanner.nextLine();
            //发送数据到服务器
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
            socketChannel.write(buffer);
        }
    }

    public static void main(String[] args) {
        try {
            ChatRoomClient client = new ChatRoomClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
