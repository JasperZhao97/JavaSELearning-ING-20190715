package com.demo.socket;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用Socket模拟HTTP服务器
 */
public class HttpServer {

	private static String root = "src/com/demo/webcontent";
	private static Map<String, String> mimes;

	static {
		mimes = new HashMap<>();
		mimes.put(".html", "text/html");
		mimes.put(".jpg", "image/jpeg");
		mimes.put(".png", "image/png");
		mimes.put(".gif", "image/gif");
		mimes.put(".txt", "text/plain");
		mimes.put(".ico", "image/x-icon");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String CRLF = "\r\n";
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
