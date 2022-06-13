package org.example;

import org.example.pojo.Student;
import org.example.service.StudentService;

import java.util.Date;

/**
 * @package:org.example
 * @class:StudentDemo
 * @description:// T主要使用
 * @author: zzw
 * @date:2022/5/3 19:48
 */
public class StudentDemo {

    public static void main(String[] args){
        Student stu = new Student(1010, "2040121213",
                "李大明", 20);

        StudentService service = new StudentService();

        service.save(stu);

        System.out.println("Java对象持久化到关系数据库表成功!" +
                new Date().toString());

    }

}
