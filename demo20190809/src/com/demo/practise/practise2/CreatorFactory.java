package com.demo.practise.practise2;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Modifier;

/**
 * 创建指定包下类对象的工厂
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月12日 11:14:17
 */
public class CreatorFactory {

    private static CreatorFactory creatorFactory;
    private static String packagePath;
    private Object[] objects = new Object[10];
    private int size;

    private CreatorFactory() {
        init("src/"+packagePath.replace(".", "/"));
    }

    public static CreatorFactory getInstance(String packagePath) {
        if(creatorFactory==null) {
            CreatorFactory.packagePath = packagePath;
            creatorFactory = new CreatorFactory();
        }
        return creatorFactory;
    }

    /**
     * 初始化工厂
     * 创建指定路径的包下类的对象，并储存到工厂容器中
     * @param packagePath
     */
    private void init(String packagePath) {
        try {
            //创建目录文件
            File dir = new File(packagePath);
            //获得子文件
            File[] files = dir.listFiles();
            //变量数组
            for (File file : files) {
                //判断是否是文件
                if (file.isFile()) {
                    //获得文件路径
                    String fileName = file.getName();
                    //获得类名
                    String className = packagePath.substring(4).replaceAll("/", ".")
                            + "." + fileName.substring(0, fileName.lastIndexOf(".java"));
                    //System.out.println(className);
                    //获得类信息对象
                    Class classz = Class.forName(className);
                    //判断是否是工厂类或是否接口或是否是抽象类
                    if(classz==this.getClass()||classz.isInterface()||classz.getModifiers()>= Modifier.ABSTRACT) {
                        continue;
                    }
                    //创建对象，同时添加数组中
                    objects[size++] = classz.newInstance();
                } else {
                    init(packagePath + "/" + file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SimpleFileName implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".java");
        }
    }

    /**
     * 查找对象
     * @param classz
     * @return
     */
    public Object find(Class classz) {
        //System.out.println(classz);
        //遍历储存对象的容器数组
        for(int i=0; i<size; i++) {
            //比较对象类型是否相等
            if(objects[i].getClass()==classz) {
                return objects[i];
            }
        }
        return null;
    }


    /*public static void main(String[] args) {
        CreatorFactory cf = CreatorFactory.getInstance("com.demo.work");
        for (Object o: cf.objects) {
            System.out.println(o);
        }
    }*/

}
