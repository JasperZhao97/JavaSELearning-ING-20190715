package com.demo.practise.practise2.pojo;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月13日  16:32:11
 */
public class Class implements Serializable {

    private String className;

    public Class() {
    }

    public Class(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
