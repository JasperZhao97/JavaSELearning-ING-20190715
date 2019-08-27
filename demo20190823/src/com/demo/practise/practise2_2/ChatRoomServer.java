package com.demo.practise.practise2_2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 聊天室服务器
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月26日 09:38:55
 */
public class ChatRoomServer {

    public List<SocketChannel> channelList = new ArrayList<>(); //定义封装通道的集合

    public ChatRoomServer() throws IOException {
        init();
    }

    /**
     * 初始化
     */
    public void init() throws IOException {
        //创建服务器通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞IO
        serverSocketChannel.configureBlocking(false);
        //绑定服务器端口号
        serverSocketChannel.bind(new InetSocketAddress(1888));
        //创建选择器
        Selector selector = Selector.open();
        //服务器通道注册给选择器，绑定"可接收连接请求"事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("启动服务器成功!");
        //循环选择通道并处理
        while(true) {
            //定义变量记录当前处理数据的通道的key对象
            SelectionKey currentKey = null;
            try {
                //选择器选择通道
                selector.select();
                //若选择获得到通道，获得通道迭代器
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //迭代遍历集合
                while (iterator.hasNext()) {
                    //获得选择键对象
                    SelectionKey selectionKey = iterator.next();
                    //记录当前的Key对象
                    currentKey = selectionKey;
                    //选择集合中移除当前通道的key
                    iterator.remove();
                    //判断触发事件类型
                    if (selectionKey.isAcceptable()) { //可接收连接请求事件
                        //获得服务器通道
                        ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                        //获得服务器与客户端连接的通道
                        SocketChannel socketChannel = serverChannel.accept();
                        //设置通道的阻塞模式：非阻塞
                        socketChannel.configureBlocking(false);
                        //通道注册给选择器并绑定可读事件
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        //添加通道到集合中
                        channelList.add(socketChannel);
                    } else if (selectionKey.isReadable()) { //可读事件
                        //获得服务器与客户端连接的通道
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        //创建缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(10 * 1024);
                        //读取数据
                        int len = socketChannel.read(buffer);
                        //提取缓冲区中的数据
                        String data = new String(buffer.array());
                        //遍历通道集合
                        for (SocketChannel channel : channelList) {
                            if (channel != socketChannel) {
                                //输出数据到某个客户端
                                buffer = ByteBuffer.wrap(data.getBytes());
                                channel.write(buffer);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                //关闭通道, 取消绑定的事件
                currentKey.cancel();
                //通道集合移除通道
                channelList.remove(currentKey.channel());
            }
        }
    }

    public static void main(String[] args) {
        try {
            ChatRoomServer server = new ChatRoomServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
