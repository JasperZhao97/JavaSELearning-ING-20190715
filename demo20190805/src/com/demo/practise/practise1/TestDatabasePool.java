package com.demo.practise.practise1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  19:15:16
 */
public class TestDatabasePool {

    public static void main(String[] args) throws IOException {
        //创建DatabasePool类的对象
        DatabasePool databasePool = new DatabasePool();
        //获取.properties文件的属性
        StringBuffer stringBuffer = databasePool.getter();
        System.out.println(stringBuffer);
        //设置.properties文件的属性
        databasePool.setter("connection.minSize","111");
        //获取.properties文件的属性
        System.out.println("----------------------------------------");
        stringBuffer = databasePool.getter();
        System.out.println(stringBuffer);
    }
}
