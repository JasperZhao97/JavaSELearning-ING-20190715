package com.demo.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 进行Http通信
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月26日  14:49:16
 */
public class Test2 {

    public static void main(String[] args) {

        try {
            //创建url对象
            URL url = new URL("http://image.baidu.com/search/index?tn=baiduimage&ps=1&ct=201326592&lm=-1&cl=2&nc=1&ie=utf-8&word=tup");
            //创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //得到缓冲字符输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //获得url，进行正则表达式匹配
            String picPathStr ;
            while ((picPathStr=in.readLine())!=null) {
                System.out.println(picPathStr);
                //匹配图片url的正则表达式
                String pattern = "^http[s]?：/";
                //正则表达式模板
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(picPathStr);

                //如果正则表达式在某一行匹配到一个式子
                if (m.find()) {
                    File file = new File(picPathStr);
                    URL url1 = new URL(picPathStr);
                    HttpURLConnection connection2 = (HttpURLConnection) url.openConnection();
                    BufferedReader in2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("g:/myfile/"+File.separator+file.getName()))));
                    String linData;
                    while ((linData=in2.readLine())!=null){
        //                System.out.println(linData);
                        out.write(linData);
                    }
                    in2.close();
                    out.close();
                } else {
                }
            }
            in.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
