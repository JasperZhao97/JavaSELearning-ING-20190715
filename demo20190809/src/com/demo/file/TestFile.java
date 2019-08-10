package com.demo.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Timestamp;

/**
 * 测试文件类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月09日 10:08:29
 */
public class TestFile {

    private MyFileNameFilter fileNameFilter = new MyFileNameFilter();

    /**
     * 自定义文件过滤器
     * 教程：https://www.cnblogs.com/gengaixue/p/8066515.html
     */
    class MyFileNameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            //System.out.println(name);
            return name.endsWith(".java");
        }
    }

    /**
     * 打印输出指定目录下所有文件，包括子级目录的文件
     * @param dirPath
     */
    public void printFileMessage(String dirPath, String prefix) {
        //创建目录对象
        File dir = new File(dirPath);
        //判断是否不是目录
        if(!dir.isDirectory()) {
            return;
        }
        //获得目录中文件及子目录的数组
        File[] files = dir.listFiles(fileNameFilter);
        //遍历数组
        for(File file: files) {
            //判断是否是目录
            if(file.isDirectory()) {
                //System.out.println(prefix+file.getPath());
                System.out.println(prefix+file.getName());
                //递归
                printFileMessage(file.getPath(), prefix+"  ");
            } else {
                //System.out.println(prefix+file.getPath());
                System.out.println(prefix+file.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /*//创建目录的对象
        //File dir = new File("d:/myfile");
        File dir = new File("D:\\MYfile");
        System.out.println(dir);
        //创建目录下的文件对象
        File file = new File(dir, "HelloWorld.java");
        System.out.println(file);
        //URL(统一资源定位符)、URI（通用资源标志符）
        System.out.println(file.toURL()); //过时，不推荐使用
        System.out.println(file.toURI());
        //获得文件的路径
        System.out.println(file.getPath());
        //获得父级目录
        System.out.println(file.getParentFile()); //File对象，注意: File重写toString方法，所以输出的也是文件路径
        //获得父级目录的路径
        System.out.println(file.getParent()); //字符串路径
        //获得文件的绝对路径
        System.out.println(file.getAbsolutePath());
        //获得文件名
        System.out.println(file.getName());
        //判断是否是文件
        System.out.println(file.isFile());
        //判读是否时目录
        System.out.println(file.isDirectory());
        //判读文件是否存在
        System.out.println(file.exists());
        System.out.println(new File(dir,"work.txt").exists());
        //获得文件大小
        System.out.println(file.length());
        //获得文件最新修改时间
        System.out.println(new Timestamp(file.lastModified()));
        //创建一个目录
        File subDir = new File(dir, "test");
        subDir.mkdir();
        //目录中创建文件
        File subFile = new File(subDir, "test.txt");
        subFile.createNewFile();*/
        /*//获得并输出myfile目录下的所有文件
        File dir = new File("d:/myfile/");
        //获得目录及文件的数组
        File[] files = dir.listFiles();
        //遍历文件数组
        for(File file: files) {
            System.out.println(file.getPath());
        }*/

        //练习：获得指定目录下所有文件，包括子集目录下的文件
        TestFile tf = new TestFile();
        tf.printFileMessage("d:/myfile", "");
    }

}
