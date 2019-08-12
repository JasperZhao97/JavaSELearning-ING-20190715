package com.demo.practise;

import com.demo.practise.pojo.Cat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月12日  19:35:00
 */
public class TestObjectStream {

    public Object[] read(String path) throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Object[] objects = new Object[100];
        int count = 0;
        Object object;
        while((object=objectInputStream.readObject())!=null) {
            objects[count] = object;
            count++;
        }
        Object[] newObjects = new Object[count];
        for(int i = 0;i<newObjects.length;i++){
            newObjects[i] = objects[i];
        }
        objectInputStream.close();
        return newObjects;
    }

    public void write(String path, Object... objects) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        for (Object object : objects) {
            objectOutputStream.writeObject(object);
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.close();
    }

    public static void main(String[] args) {
        TestObjectStream testObjectStream = new TestObjectStream();
        try {
            /*testObjectStream.write("demo20190812/src/com/demo/practise/data.ser",
                    new Cat("加菲","黄色 ","中"),
                    new Cat("狸花猫","花色","轻"));*/
            Object[] objects = testObjectStream.read("demo20190812/src/com/demo/practise/data.ser");
            for(Object object:objects){
                Cat cat = (Cat)object;
                System.out.println(cat.getType()+""+cat.getColor()+""+cat.getSize());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
