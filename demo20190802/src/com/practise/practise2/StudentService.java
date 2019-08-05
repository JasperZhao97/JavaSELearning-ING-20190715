package com.practise.practise2;

/**
 * 服务类
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月04日  17:18:50
 */
public class StudentService {

    private Student[] students;

    public StudentService(Student[] students) {
        this.students = students;
    }

    String printSingle() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("姓名：" + students[0].getName());
        stringBuffer.append(",年龄：" + students[0].getAge());
        stringBuffer.append(",性别：" + students[0].getGender());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    String printAlot() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < students.length; i++) {
            stringBuffer.append("{");
            stringBuffer.append("姓名：" + students[i].getName());
            stringBuffer.append(",年龄：" + students[i].getAge());
            stringBuffer.append(",性别：" + students[i].getGender());
            stringBuffer.append("}");
            if (i < students.length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }


    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
