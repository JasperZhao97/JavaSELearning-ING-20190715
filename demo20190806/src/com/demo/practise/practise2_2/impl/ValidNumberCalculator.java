package com.demo.practise.practise2_2.impl;


import com.demo.practise.practise2_2.ICalculator;

/**
 * 算术运算实现类，不超过两位小数
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月08日 09:41:03
 */
public class ValidNumberCalculator implements ICalculator {

    @Override
    public double sum(double x, double y) {
        return Math.round((x+y)*100)/100d;
    }

    @Override
    public double subtraction(double x, double y) {
        return Math.round((x-y)*100)/100d;
    }
}
