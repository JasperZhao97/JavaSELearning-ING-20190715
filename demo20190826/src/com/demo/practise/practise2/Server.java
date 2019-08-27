package com.demo.practise.practise2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月26日  19:14:21
 */
public class Server {

    public static void server(String root, String CRLF, Map<String,String> mimes){
        try {
            ServerSocket server = new ServerSocket(80);
            while (true) {
                final Socket con = server.accept();
                Thread serverThread = new Thread() {
                    public void run() {
                        try {
                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(con.getInputStream()));
							/*String inLine;
							while((inLine=in.readLine())!=null&&!"".equals(inLine)) {
								System.out.println(inLine);
							}
							//in.close();*/
                            //获取请求行
                            String requestLine = in.readLine();
                            //System.out.println(requestLine);
                            //提取请求路径
                            String requestUri = requestLine.substring(requestLine.indexOf("/"),
                                    requestLine.lastIndexOf("HTTP")-1);
                            //System.out.println(requestUri);
                            //创建服务器根目录文件
                            File dir = new File(root);
                            //判断请求路径是否根目录
                            if("/".equals(requestUri)) {
                                //设置请求默认页面
                                requestUri = "/index.html";
                            } else if("/favicon.ico".equals(requestUri)) {
                                //标题小图标路径
                                requestUri = "/favicon.png";
                            }
                            //创建访问目标文件
                            File targetFile = new File(dir, requestUri);
                            System.out.println(targetFile.getPath());
                            //获得响应客户端的输出流
                            OutputStream os = con.getOutputStream();
                            //判断请求文件是否不存在
                            if(!targetFile.exists()) {
                                //响应客户端
                                String responseHeader = "HTTP/1.1 404" + CRLF;  //状态行
                                responseHeader += "Content-Type: text/html" + CRLF; //响应头
                                os.write(responseHeader.getBytes());
                            } else {
                                //获得文件长度
                                long length = targetFile.length();
                                //获得文件类型
                                String suffix = targetFile.getName().substring(targetFile.getName().lastIndexOf("."));
                                String type = mimes.get(suffix);
                                //响应客户端
                                String responseHeader = "HTTP/1.1 200 OK" + CRLF;  //状态行
                                responseHeader += "Content-Type: " + type + CRLF; //响应头
                                responseHeader += "Content-Length:  " + length
                                        + CRLF;
                                responseHeader += CRLF;
                                //输出状态行或响应头
                                os.write(responseHeader.getBytes());
                                //循环输出响应内容
                                FileInputStream fis = new FileInputStream(targetFile);
                                byte[] buf = new byte[1024*1024];
                                int len = 0;
                                while ((len = fis.read(buf)) != -1) {
                                    os.write(buf, 0, len);
                                }
                                fis.close();
                            }
                            os.flush();
                            os.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                serverThread.start();

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
