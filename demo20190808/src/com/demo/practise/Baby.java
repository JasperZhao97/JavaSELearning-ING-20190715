package com.demo.practise;

import java.util.Date;

/**
 * 孩子类
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月08日  20:14:28
 */
public class Baby {

    private String name;
    @DateAnnotation(value = "2008-08-08 08:08:08")
    private Date birsthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirsthday() {
        return birsthday;
    }

    public void setBirsthday(Date birsthday) {
        this.birsthday = birsthday;
    }
}
