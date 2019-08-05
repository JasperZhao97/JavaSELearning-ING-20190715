package com.demo.apis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  11:26:26
 */
public class TestProperties {

    public static void main(String[] args) {
        try {
            //创建属性列表对象
            Properties properties = new Properties();
            //加载Properties文件中的数据
            properties.load(new FileInputStream("demo20190805/src/com/demo/apis/test.properties"));
            //获取属性值
            System.out.println(properties.getProperty("goodName"));
            System.out.println(properties.getProperty("goodsPrice"));
            System.out.println(properties.getProperty("goodsTotal"));
            //设置属性
            properties.setProperty("gooodName","雪碧");
            properties.setProperty("gooodsprice","3.5");
            //保存属性到文件
            properties.store(new FileOutputStream("demo20190805/src/com/demo/apis/test.properties"),"商品信息");
            System.out.println("修改属性列表数据成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
