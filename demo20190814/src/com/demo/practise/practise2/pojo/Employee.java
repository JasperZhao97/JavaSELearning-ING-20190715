package com.demo.practise.practise2.pojo;

/**
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月14日  20:18:45
 */
public class Employee {

    private String IdCar;
    private String name;

    public Employee() {
    }

    public Employee(String idCar, String name) {
        IdCar = idCar;
        this.name = name;
    }

    public String getIdCar() {
        return IdCar;
    }

    public void setIdCar(String idCar) {
        IdCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "员工卡号：" + IdCar +
                ", 员工姓名：" + name ;
    }
}
