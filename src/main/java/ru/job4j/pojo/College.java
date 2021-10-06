package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Васильев Егор Евгеньевич");
        student.setGroup("01a");
        student.setCreated(new Date());

        System.out.println(student.getFIO() + " учится в группе № " + student.getGroup());
    }
}
