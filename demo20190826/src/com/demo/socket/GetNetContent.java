package com.demo.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取网页中的内容
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月26日 14:49:56
 */
public class GetNetContent {

    public static void main(String[] args) {
        try {
            //创建路径对象
            URL url = new URL("http://news.baidu.com/");
            //创建HTTP连接对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //获得输入流
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            //定义字符串变量，记录按行读取的数据
            String lineData;
            //创建字符串缓冲区，存放网页的内容
            StringBuffer content = new StringBuffer();
            while((lineData=in.readLine())!=null) {
                content.append(lineData);
                //System.out.println(lineData);
            }
            //创建正则表达式对象
            Pattern pattern = Pattern.compile("http[s]?:/(/[_.?=%: A-Za-z0-9]+)+(\'|\")");
            //创建匹配器
            Matcher matcher = pattern.matcher(content.toString());
            //循环查找匹配的字符串
            while(matcher.find()) {
                //System.out.println(matcher.group(0)+"  "+matcher.start()+","+matcher.end()+", "+matcher.groupCount());
                System.out.println(matcher.group(0).replaceAll("'|\"", ""));
                int groupCount = matcher.groupCount();
                /*for(int i=0; i<groupCount; i++) {
                    System.out.println(matcher.group(i));
                }*/
            }
            //关闭流
            in.close();
            //断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
