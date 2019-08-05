package com.apis;

import java.io.IOException;

/**
 * 测试运行时类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月02日 16:43:17
 */
public class TestRuntime {

    public static void main(String[] args) {
        //获得运行对象
        Runtime runtime = Runtime.getRuntime();
        //打开一个word文档
        try {
            runtime.exec("C:\\Users\\Administrator\\AppData\\Local\\Kingsoft" +
                    "\\WPS Office\\11.1.0.8894\\office6\\wps.exe D:\\zrgj\\考试\\第2周\\" +
                    "Java全栈工程师阶段测试试题-参考答案.docx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
