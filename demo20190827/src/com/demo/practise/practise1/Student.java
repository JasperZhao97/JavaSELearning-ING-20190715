package com.demo.practise.practise1;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月27日  19:36:13
 */
public class Student {

    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 重写finalize方法
     */
    @Override
    protected void finalize() throws Throwable {
        //调用父类的清楚方法，完整清理
        super.finalize();
        System.out.println("关闭资源");
    }
}
