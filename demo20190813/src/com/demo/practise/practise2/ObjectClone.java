package com.demo.practise.practise2;

import java.io.*;
import java.lang.reflect.Field;

/**
 * 实现对任意对象深度克隆
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  19:54:14
 */
public class ObjectClone {

    public <T>T cloneObjecr(T t) throws Exception {
        //创建数组字节输出流
        ByteArrayOutputStream outputByte = new ByteArrayOutputStream();
        //创建对象输出流
        ObjectOutputStream objectOutput = new ObjectOutputStream(outputByte);
        //克隆对象
        objectOutput.writeObject(t);
        //提取克隆对象
        ObjectInputStream objectInput = new ObjectInputStream(new ByteArrayInputStream(outputByte.toByteArray()));
        return (T)objectInput.readObject();
    }
}
