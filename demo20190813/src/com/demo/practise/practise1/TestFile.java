package com.demo.practise.practise1;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  19:09:27
 */
public class TestFile {

    public static void main(String[] args) {
        try {
            FileUtil fileUtil = new FileUtil();
//            fileUtil.copyFile("demo20190813/src/com/demo/practise/practise1/test1.txt",
//                    "demo20190813/src/com/demo/practise/practise1/test2.txt");
            fileUtil.setType("1.txt");
            fileUtil.copyFile("demo20190813/src/com/demo/practise/practise1/test1.txt",
                    "demo20190813/src/com/demo/practise/practise1/test2.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
