package com.demo.practise.practise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 文件处理类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月10日  16:46:46
 */
public class FileService {


    /**
     * 复制指定路径的文件
     * 未指定路径，复制到g:/myfile/picture1
     *
     * @param oldpath
     * @throws Exception
     */
    public void methodCopy(String oldpath) throws Exception {
        File file1 = new File(oldpath);
        File[] files = file1.listFiles();
        for (File file2 : files) {
            if (file2.isDirectory()) {
                methodCopy(file2.getPath());
            } else if (file2.getName().endsWith("jpg") || file2.getName().endsWith("jpeg") || file2.getName().endsWith("png") || file2.getName().endsWith("gif")) {
                //创建输入流
                FileInputStream fileInputStream = new FileInputStream(file2);
                //创建输出流
                File file3 = new File("g:/myfile/picture1");
                //创建新的图片名
                String string = file2.getName();
                FileOutputStream fileOutputStream = new FileOutputStream(file3 + "/" + string);
                byte[] bytes = new byte[1024 * 1024];
                int len;
                //读写数据
                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileInputStream.close();
                // 关闭输出流前强制写出所有输出字节
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }

    /**
     * 复制指定路径的文件到指定目录。
     *
     * @param oldpath
     * @param newpath
     * @throws Exception
     */
    public void methodCopy(String oldpath, String newpath) throws Exception {
        File file1 = new File(oldpath);
        File[] files = file1.listFiles();
        for (File file2 : files) {
            if (file2.isDirectory()) {
                methodCopy(file2.getPath(), newpath);
            } else if (file2.getName().endsWith("jpg") || file2.getName().endsWith("jpeg") || file2.getName().endsWith("png") || file2.getName().endsWith("gif")) {
                //创建输入流
                FileInputStream fileInputStream = new FileInputStream(file2);
                //创建输出流
                File file3 = new File(newpath);
                //创建新的图片名
                String string = file2.getName();
                FileOutputStream fileOutputStream = new FileOutputStream(file3 + "/" + string);
                byte[] bytes = new byte[1024 * 1024];
                int len;
                //读写数据
                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileInputStream.close();
                // 关闭输出流前强制写出所有输出字节
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }
}
