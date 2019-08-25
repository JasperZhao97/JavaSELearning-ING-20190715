package com.demo.socket;

import java.util.*;

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月23日 10:51:11
 */
public class Test {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("Tom","Lily","Jack","Rose","Davin"));
        Iterator<String> it = set.iterator();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
        it.remove();
        System.out.println(set.size());
        System.out.println(set);
    }

}
