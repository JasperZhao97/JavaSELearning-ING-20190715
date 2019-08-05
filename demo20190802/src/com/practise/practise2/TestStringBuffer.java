package com.practise.practise2;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月04日  17:16:47
 */
public class TestStringBuffer {

    public static void main(String[] args) {
        Student[] students1 = {new Student("张三", 18, "男")};
        Student[] students2 = {new Student("李四", 20, "男"),
                new Student("王芳", 22, "女")};
        StudentService studentService1 = new StudentService(students1);
        StudentService studentService2 = new StudentService(students2);

        //输出某个对象
        String string1 = studentService1.printSingle();
        System.out.println(string1);

        //输出多个对象
        String string2 = studentService2.printAlot();
        System.out.println(string2);
    }
}
