package com.practise.practise2_2;

/**
 * 学生的服务类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年08月05日 10:35:26
 */
public class StudentService {

    /*public String formatJSON(Student student) {
        System.out.println(1);
        return null;
    }

    public String formatJSON(Student...studeng) {
        System.out.println(2);
        return null;
    }

    public static void main(String[] args) {
        StudentService ss = new StudentService();
        ss.formatJSON(new Student());  // 1
    }*/

    /**
     * 格式化学生对象，返回JSON格式字符串
     * @param student
     * @return
     */
    public String formatJSON(Student student) {
        StringBuffer stuff = new StringBuffer();
        stuff.append('{');
        stuff.append("name:\"");
        stuff.append(student.getName());
        stuff.append("\",");
        stuff.append("gender:\"");
        stuff.append(student.getGender());
        stuff.append("\",");
        stuff.append("age:");
        stuff.append(student.getAge());
        stuff.append('}');
        return stuff.toString();
    }

    /**
     * 格式化学生数组。返回JSON格式字符串
     * @param students
     * @return
     */
    public String formatJSON(Student...students) {
        StringBuffer stuff = new StringBuffer();
        stuff.append('[');
        for(int i=0; i<students.length; i++) {
            Student student = students[i];
            if(i>0) {
                stuff.append(",");
            }
            stuff.append("{");
            stuff.append("name:\"");
            stuff.append(student.getName());
            stuff.append("\",");
            stuff.append("gender:\"");
            stuff.append(student.getGender());
            stuff.append("\",");
            stuff.append("age:");
            stuff.append(student.getAge());
            stuff.append('}');
        }
        stuff.append(']');
        return stuff.toString();
    }

}
