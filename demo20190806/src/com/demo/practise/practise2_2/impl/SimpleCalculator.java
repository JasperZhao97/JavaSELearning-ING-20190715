package com.demo.practise.practise2_2.impl;


import com.demo.practise.practise2_2.ICalculator;

/**
 * 简单算术运算实现类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月08日 09:37:21
 */
public class SimpleCalculator implements ICalculator {

    @Override
    public double sum(double x, double y) {
        return x+y;
    }

    @Override
    public double subtraction(double x, double y) {
        return x-y;
    }
}
