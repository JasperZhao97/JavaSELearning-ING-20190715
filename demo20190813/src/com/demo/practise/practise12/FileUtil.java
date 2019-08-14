package com.demo.practise.practise12;

import java.io.*;

/**
 * 文件处理工具类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 09:37:07
 */
public class FileUtil {

    private String fileType; //文件类型   多个类型表示方式：.后缀1,后缀2,...
    private Integer length = 2*1024*1024; //文件最大长度

    public FileUtil() {
    }

    public FileUtil(String fileType) {
        this.fileType = fileType;
    }

    public FileUtil(String fileType, Integer length) {
        this.fileType = fileType;
        this.length = length;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 赋值文件到指定目录
     * @param sourcePath
     * @param targetDirPath
     * @throws Exception
     */
    public void copyFile(String sourcePath, String targetDirPath) throws Exception {
        //创建资源文件
        File sourceFile = new File(sourcePath);
        //创建目录
        File targetDir = new File(targetDirPath);
        //获得资源文件后缀
        String sourceFileSuffix = sourceFile.getName().substring(
                sourceFile.getName().lastIndexOf("."));
        //判断文件类型是否不符合
        if(fileType!=null&&!fileType.contains(sourceFileSuffix.toLowerCase())) {
            throw new Exception("文件的类型不匹配，可使用文件类型: "+fileType);
        }
        //判断是否超过最大文件长度
        if(sourceFile.length()>length) {
            throw new Exception("超过最大文件长度: "+length+"B(字节)");
        }
        //判断目录是否不存在
        if(!targetDir.exists()) {
            targetDir.mkdirs();
        }
        //创建文件字节输入输出流
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(new File(targetDir, sourceFile.getName()));
        //创建数组，存放每次读取到的字节数据
        byte[] b = new byte[1024*1024];
        //定义整型变量，记录每次读取出的字节数量
        int len;
        //循环复制文件数据
        while((len=in.read(b))!=-1) {
            out.write(b, 0, len);
        }
        //关闭流
        out.close();
        in.close();
        System.out.println("复制文件成功!");
    }

    public static void main(String[] args) {
        try {
            FileUtil fileUtil = new FileUtil(".txt,.doc,.docx,.jpg,.jpeg,.png,.gif");
            fileUtil.copyFile("C:\\Users\\Administrator" +
                    "\\Desktop\\课程记录0813.docx", "D:\\myfile");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
