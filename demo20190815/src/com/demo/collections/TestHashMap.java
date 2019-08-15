package com.demo.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 测试应用散列图
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 16:33:32
 */
public class TestHashMap {

    public static void main(String[] args) {
        //创建散列图集合
        HashMap<String, Object> map = new HashMap<>();
        //添加元素
        map.put("goodsName", "可口可乐");
        map.put("goodsPrice", 5);
        map.put("goodsTotal", 100);
        //获得元素的值
        System.out.println(map.get("goodsName")+", "
                +map.get("goodsPrice")+", "+map.get("goodsTotal"));
        //遍历图集合
        /*for(Map.Entry<String, Object> o: map) { //遍历失败，图不能使用forEach

        }*/
        //获得键值对集合
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        System.out.println(entrySet);
        //遍历键值对集合
        for(Map.Entry<String, Object> entry: entrySet) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
        //修改元素
        map.put("goodsPrice", 3);
        //删除元素
        map.remove("goodsTotal");
        System.out.println(map);
    }

}
