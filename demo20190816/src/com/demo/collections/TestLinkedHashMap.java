package com.demo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 测试应用链式散列图
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月16日 10:55:57
 */
public class TestLinkedHashMap {

    public static void main(String[] args) {
        //创建链式散列图集合
        //LinkedHashMap<String, Object> map = new LinkedHashMap<>(); //插入顺序， 默认
        LinkedHashMap<String, Object> map = new LinkedHashMap<>(
                16, 0.75f, true); //访问顺序，即元素最后一次被访问的先后顺序
        //添加元素
        map.put("name", "张山");
        map.put("gender", "男");
        map.put("age", 22);
        map.put("mobileNumber", "13056388972");
        System.out.println(map.get("age"));
        //遍历集合
        /*for(String key: map.keySet()) {
            System.out.println(key+" = "+map.get(key));
        }*/
        for(Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }

}
