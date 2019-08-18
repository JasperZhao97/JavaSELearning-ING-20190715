package com.demo.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试应用树型图
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月16日 11:18:52
 */
public class TestTreeMap {

    public static void main(String[] args) {
        //创建树型图集合
        TreeMap<String, Object> map = new TreeMap<>();
        //添加元素
        map.put("name", "张山");
        map.put("gender", "男");
        map.put("age", 22);
        map.put("mobileNumber", "13056388972");
        //遍历元素
        for(Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }

}
