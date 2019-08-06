package com.demo.practise.practise1_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * 数据访问链接池
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月06日 10:51:01
 */
public class DatabasePool {

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    private static Integer minSize;
    private static Integer maxSize;
    private static Integer timeout;
    private static Integer maxStatement;

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/com/demo/work/datasource.properties"));
            /*driverClass = props.getProperty("connection.driverClass");
            url = props.getProperty("connection.url");
            username = props.getProperty("connection.username");
            password = props.getProperty("connection.password");
            minSize = Integer.parseInt(props.getProperty("connection.minSize").trim());
            maxSize = Integer.parseInt(props.getProperty("connection.maxSize").trim());
            timeout = Integer.parseInt(props.getProperty("connection.timeout").trim());
            maxStatement = Integer.parseInt(props.getProperty("connection.maxStatement").trim());*/
            Class poolClass = DatabasePool.class;
            Field[] fields = poolClass.getDeclaredFields();
            DatabasePool pool = new DatabasePool();
            for(Field field: fields) {
                if(field.getType()==Integer.class) {
                    field.set(pool, Integer.parseInt(props.getProperty("connection."+field.getName()).trim()));
                } else {
                    field.set(pool, props.getProperty("connection."+field.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDriverClass() {
        return driverClass;
    }

    public static void setDriverClass(String driverClass) {
        DatabasePool.driverClass = driverClass;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DatabasePool.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DatabasePool.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DatabasePool.password = password;
    }

    public static Integer getMinSize() {
        return minSize;
    }

    public static void setMinSize(Integer minSize) {
        DatabasePool.minSize = minSize;
    }

    public static Integer getMaxSize() {
        return maxSize;
    }

    public static void setMaxSize(Integer maxSize) {
        DatabasePool.maxSize = maxSize;
    }

    public static Integer getTimeout() {
        return timeout;
    }

    public static void setTimeout(Integer timeout) {
        DatabasePool.timeout = timeout;
    }

    public static Integer getMaxStatement() {
        return maxStatement;
    }

    public static void setMaxStatement(Integer maxStatement) {
        DatabasePool.maxStatement = maxStatement;
    }

    public static void main(String[] args) {
        try {
            DatabasePool pool = new DatabasePool();
            //获得所得属性对象
            Field[] fields = DatabasePool.class.getDeclaredFields();
            System.out.println(fields.length);
            for(Field field: fields) {
                System.out.println(field.getName()+" = "+field.get(pool));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
