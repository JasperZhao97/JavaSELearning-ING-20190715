package com.demo.io;

import com.demo.io.pojo.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月12日  17:00:46
 */
public class TestObjectStream {

    /**
     * 读取文件中的对象
     * @param path
     * @return
     * @throws Exception
     */
    public Object[] read(String path) throws Exception {
        //创建对象输入流
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        //创建数组，用于存储读取到的对象
        Object[] objects = new Object[100];
        System.out.println(objects[50]);
        //定义变量记录读取到对象的个数
        int count = 0;
        //定义缓存每次读取到的对象
        Object object;
        //循环读取对象
        while ((object=objectInputStream.readObject())!=null){
            objects[count] = object;
            count++;
        }
        //创建数组，去除对象数组中null元素
        Object[] reObjects = new Object[count];
        for(int i = 0;i<reObjects.length;i++){
            reObjects[i] = objects[i];
        }
        //关闭流
        objectInputStream.close();
        return reObjects;
    }

    /**
     * 写人对象到文件中
     * @param path
     * @param objects
     * @throws Exception
     */
    public void write(String path, Object... objects) throws Exception {
        //创建对象流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        //
        for(Object object:objects){
            objectOutputStream.writeObject(object);
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.close();
    }

    public static void main(String[] args) {
        TestObjectStream testObjectStream = new TestObjectStream();
        try {
            /*testObjectStream.write("demo20190812/src/com/demo/io/data.ser",
                    new Student("张三","男","18"),
                    new Student("莉莉","女","17"));*/
            Object[] objects = testObjectStream.read("demo20190812/src/com/demo/io/data.ser");
            for(Object object:objects){
                Student student = (Student)object;
                System.out.println("姓名："+student.getName()+"\t性别："+student.getGender()+"\t\t0年龄："+student.getAge());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
