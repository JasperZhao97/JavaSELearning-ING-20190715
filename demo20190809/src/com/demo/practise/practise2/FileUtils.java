package com.demo.practise.practise2;

import java.io.*;

/**
 * 文件处理的工具类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月12日 10:42:50
 */
public class FileUtils {

    /**
     * 定义文件处理工具类，定义方法复制指定路径的文件到指定目录
     * @param sourceFilePath
     * @param targetDirPath
     * @throws Exception
     */
    public static void copyFile(String sourceFilePath, String targetDirPath) throws Exception {
        //创建要复制的文件对象
        File sourceFile = new File(sourceFilePath);
        //创建存放文件的目录对象
        File targetDir;
        if(targetDirPath==null||"".equals(targetDirPath)) {
            //默认存放在当前用户目录下
            targetDir = new File(System.getProperty("user.home")+"/copyfiles");
        } else {
            targetDir = new File(targetDirPath);
        }
        //判断目录是否存在
        if(!targetDir.exists()) {
            //创建目录
            targetDir.mkdirs();
        }
        //打开输入输出流
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(new File(targetDir, sourceFile.getName()));
        //定义缓存数据的数组
        byte[] b = new byte[1024*1024];
        //定义变量，记录读取的字节数
        int len;
        //循环复制文件
        while((len=in.read(b))!=-1) {
            out.write(b, 0, len);
        }
        //关闭流
        out.close();
        in.close();
    }

    public static void main(String[] args) {
        try {
            /*FileUtils.copyFile("C:\\Users\\Administrator" +
                    "\\Desktop\\JAVA程序执行过程2.jpg", null);*/
            FileUtils.copyFile("C:\\Users\\Administrator" +
                    "\\Desktop\\JAVA程序执行过程2.jpg",
                    "C:\\Users\\Administrator\\Desktop\\temp");
            System.out.println("复制文件成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
