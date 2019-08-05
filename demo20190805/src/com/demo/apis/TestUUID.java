package com.demo.apis;

import java.util.UUID;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月05日  14:39:07
 */
public class TestUUID {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        System.out.println(uuidStr);
        System.out.println(uuidStr.length());
    }
}
