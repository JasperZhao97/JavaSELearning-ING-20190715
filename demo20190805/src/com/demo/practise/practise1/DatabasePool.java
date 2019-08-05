package com.demo.practise.practise1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 连接池类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  19:08:34
 */
public class DatabasePool {

    private static String driverClass;//静态成员
    private static String url;
    private static String username;
    private static String password;
    private static String minSize;
    private static String maxSize;
    private static String timeout;
    private static String maxStatement;
    private static Properties properties = new Properties();

    /**
     * 静态块
     */
    static {
        try {
            //创建属性列表对象
            //加载Properties文件中的数据
            properties.load(new FileInputStream("demo20190805/src/com/demo/practise/practise1/link.properties"));
            //获取属性值,进行封装
            driverClass = properties.getProperty("connection.driverClass");
            url = properties.getProperty("connection.url");
            username = properties.getProperty("connection.username");
            password = properties.getProperty("connection.password");
            minSize = properties.getProperty("connection.minSize");
            maxSize = properties.getProperty("connection.maxSize");
            timeout = properties.getProperty("connection.timeout");
            maxStatement = properties.getProperty("connection.maxStatement");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置属性
     */
    public void setter(String key,String value) throws IOException {
        properties.setProperty(key,value);
        properties.store(new FileOutputStream("demo20190805/src/com/demo/practise/practise1/link.properties"),null);
    }

    /**
     * 获取属性
     *
     * @return
     */
    public StringBuffer getter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("connection.driverClass = ");
        stringBuffer.append(driverClass);
        stringBuffer.append("\n");
        stringBuffer.append("connection.url = ");
        stringBuffer.append(url);
        stringBuffer.append("\n");
        stringBuffer.append("connection.username = ");
        stringBuffer.append(username);
        stringBuffer.append("\n");
        stringBuffer.append("connection.password = ");
        stringBuffer.append(password);
        stringBuffer.append("\n");
        stringBuffer.append("connection.minSize = ");
        stringBuffer.append(minSize);
        stringBuffer.append("\n");
        stringBuffer.append("connection.maxSize = ");
        stringBuffer.append(maxSize);
        stringBuffer.append("\n");
        stringBuffer.append("connection.timeout = ");
        stringBuffer.append(timeout);
        stringBuffer.append("\n");
        stringBuffer.append("connection.maxStatement = ");
        stringBuffer.append(maxStatement);
        return stringBuffer;
    }
}
