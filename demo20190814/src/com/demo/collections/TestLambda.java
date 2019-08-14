package com.demo.collections;

interface ICalculator {
    public int sum(int x, int y);
    //public int sum(int x, int y, int z);
    @Override
    public boolean equals(Object o);

    @Override
    public String toString();

    @Override
    public int hashCode();
}

class CalculatorImpl implements  ICalculator {

    @Override
    public int sum(int x, int y) {
        return 0;
    }
}

/**
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月14日 17:36:26
 */
public class TestLambda {

    public static void main(String[] args) {
        ICalculator ical = (x, y) -> x+y; //目标类型必须是接口，且只能有一个自定义抽象方法
        System.out.println(ical.sum(10, 20));
        ICalculator ic = new CalculatorImpl();
        Object o = ic;
    }

}
