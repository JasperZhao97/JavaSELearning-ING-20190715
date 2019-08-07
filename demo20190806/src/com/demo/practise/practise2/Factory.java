package com.demo.practise.practise2;

import com.demo.practise.practise2.impl.Cat;
import com.demo.practise.practise2.impl.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月06日  22:40:20
 */
public class Factory {

    private static Animals[] animals = new Animals[2];

    static {
        try {
            //创建properties对象
            Properties properties = new Properties();
            //加载properties文件
            properties.load(new FileInputStream("demo20190806/src/com/demo/practise/practise2/animals.properties"));
            //获得key的value值
            String string = properties.getProperty("interface.impls");
            //对字符串进行裁剪成字符串数组
            String[] strings2 = string.split(",");
            //将对象存进对象数组中
            for(int i = 0;i<strings2.length;i++){
//                System.out.println(str);//查看字符串数组的值
                 animals[i] = (Animals) Class.forName(strings2[i]).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据类名获取已经创建的实现类对象，若未找到对象就新建对象
     */
    public Animals methodInstance(String className) throws Exception {
        Animals animals1 = null;
        for (int i = 0;i<animals.length;i++){
            if(animals[i].getClass().toString().endsWith(className)){
                animals1 = animals[i];
                break;
            }
        }
        if(animals1==null){
            throw new Exception("错误类");
        }
        return animals1;
    }

//    private Cat cat;
//    private Dog dog;
//
//    public Factory() {
//        this.cat = new Cat();
//        this.dog = new Dog();
//    }
//
//    public String print() {
//        return cat.voice()+dog.voice();
//    }
}
