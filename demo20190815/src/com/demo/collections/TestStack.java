package com.demo.collections;

import java.util.Stack;

/**
 * 测试应用栈表
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月15日 16:11:58
 */
public class TestStack {

    public static void main(String[] args) {
        //创建栈表
        Stack stack = new Stack();
        //向栈中压入元素
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(80);
        stack.push(160);
        //获取栈元素
        System.out.println(stack.peek()); //160
        //搜索元素，返回在栈中的位置
        System.out.println(stack.search(10)); //5
        System.out.println(stack.search(160)); //1  栈顶，位置从1开始。
        //提取栈中所有元素
        while(!stack.empty()) {
            System.out.print(stack.pop()+" "); // pop(); 删除并返回栈顶元素
        }
        System.out.println();
    }

}
