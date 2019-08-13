package com.demo.practise.practise1;

import java.io.*;

/**
 * 文件处理类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  19:09:00
 */
public class FileUtil {

    private Integer size;//文件的大小
    private String type;//文件的类型

    public FileUtil() {
        //设置默认的文件大小为2M
        this.size = 2*1024*1024;
    }

    public FileUtil(Integer size, String type) {
        this.size = size;
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 文件拷贝方法
     */
    public void copyFile(String oldPath,String newPath) throws Exception {
        //判断是否是符合的文件类型
        File file = new File(oldPath);
        if(type!=null&&!file.getName().endsWith(type)){
            throw new Exception("复制的文件不符合类型");
        }
        //根据size的值设置缓冲的大小，如果未设置值，默认2MB
        //创建输入、输出流
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(oldPath),size);
        BufferedOutputStream ouput = new BufferedOutputStream(new FileOutputStream(newPath));
        byte[] bytes = new byte[size];
        int len;
        while((len=input.read(bytes))!=-1){
            ouput.write(bytes,0,len);
        }
        //关闭输出流
        ouput.close();
        //关闭输入流
        input.close();
        System.out.println("成功复制文件");
    }
}
