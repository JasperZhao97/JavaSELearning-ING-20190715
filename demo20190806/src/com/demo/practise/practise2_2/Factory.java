package com.demo.practise.practise2_2;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 创建对象的工厂类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月08日 09:45:00
 */
public class Factory {

    private ICalculator[] iCalculators;
    private static Factory factory;

    private Factory() {
        init();
    }

    /**
     * 返回工厂的实例
     * @return
     */
    public static Factory getInstance() {
        if(factory==null) {
            factory = new Factory();
        }
        return factory;
    }

    /**
     * 初始化工厂
     */
    private void init() {
        try {
            iCalculators = new ICalculator[16];
            Properties props = new Properties();
//            props.load(new FileInputStream("demo20190806/src/com/demo/practise/practise2_2/application.properties"));
            props.load(new FileInputStream("G:\\Chinasoft\\JavaSELearning-ING-20190715\\demo20190806\\src\\com\\demo\\practise\\practise2_2\\application.properties"));
            String[] classPaths = props.getProperty("interface.impls")==null
                    ? new String[]{} : props.getProperty("interface.impls").trim().split(",");
            for(int i=0; i<classPaths.length; i++) {
                Class classz = Class.forName(classPaths[i]);
                ICalculator iCalculator = (ICalculator) classz.newInstance();
                iCalculators[i] = iCalculator;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找工厂中的对象
     * @param className
     * @return
     */
    public ICalculator find(String className) throws Exception {
        //遍历数组查找对象
        for(ICalculator iCalculator: iCalculators) {
            if(iCalculator.getClass().getName().equals(className)) {
                return iCalculator;
            }
        }
        //未找到，新建对象
        System.out.println("未查找到对象，新建这个对象");
        return (ICalculator) Class.forName(className).newInstance();
    }


}
