package com.demo.practise.practise1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取网页中的内容
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月26日  22:32:59
 */
public class GetNetContent {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://news.baidu.com/");
            //创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //得到缓冲字符输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //获得url，进行正则表达式匹配
            String picPathStr;
            //创建字符串缓冲区,存放网页的内容
            StringBuffer stringBuffer = new StringBuffer();
            while ((picPathStr = in.readLine()) != null) {
                stringBuffer.append(picPathStr);
            }
            //匹配图片url的正则表达式
            String pattern = "http[s]?:/(/[_.?=%: A-Za-z0-9]+)+(\'|\")";
            //正则表达式模板
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(stringBuffer.toString());

            //存储所有url的字符串数组
            String[] strings;
            //存储图片的地址
            List<String> picStrings = new LinkedList<>();
            //循环查找匹配的字符串
            while(m.find()) {
                String s = m.group(0).replaceAll("'|\"", "");
                strings = s.split("http");
                for (String s1:strings){
                    //获得图片的url
                    if(s1.endsWith(".gif")||s1.endsWith(".png")||s1.endsWith(".img")){
                       picStrings.add("http"+s1);
                    }
                }
            }
            //循环下载图片
            for (int i = 0;i<picStrings.size();i++) {
                File file = new File(picStrings.get(i));
                //获得图片的url
                URL url1 = new URL(picStrings.get(i));
                HttpURLConnection connection2 = (HttpURLConnection) url.openConnection();
                BufferedReader in2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
                FileOutputStream out = new FileOutputStream(new File("g:/myfile/"+File.separator+file.getName()));
                String linData;
                byte[] bytes = new byte[1024*1024];
                int len = in2.read();
                while ((linData=in2.readLine())!=null){
                    out.write(bytes,0,len);
                }
                in2.close();
                out.close();
            }
            in.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
