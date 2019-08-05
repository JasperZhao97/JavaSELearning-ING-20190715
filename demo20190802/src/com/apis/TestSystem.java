package com.apis;

import javax.swing.text.html.parser.Entity;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 测试系统类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月02日 16:17:00
 */
public class TestSystem {

    public static void main(String[] args) {
        //System.exit(0);
        /*Properties props = System.getProperties();
        Set<Map.Entry<Object, Object>> set = props.entrySet();
        for(Map.Entry e: set) {
            System.out.println(e.getKey()+" = "+e.getValue());
        }*/
        //获取当前用户目录
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
        System.out.println("程序执行完毕!");
    }

}
