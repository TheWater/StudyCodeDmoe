package org.example;

import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.example.service.StudentService;
import org.example.service.TeacherService;

import java.util.Date;

/**
 * @package:org.example
 * @class:StudentDemo
 * @description:// T主要使用
 * @author: zzw
 * @date:2022/5/3 19:48
 */
public class TeacherDemo {

    public static void main(String[] args){

//        addTest();

//        deleteTest(4);

//        Teacher teacher = new Teacher(5566,"张老师", "1010", "软件工程系",
//                new Date(), "个人介绍的内容");
//        updateTest(1,teacher);

//        getTest();

        loadTest();
    }

    /**
     * 增加实验
     */
    public static void addTest(){

        Teacher teacher = new Teacher(1111, "李老师", "1212", "软件工程系",
                new Date(), "介绍一下自己");

        TeacherService service = new TeacherService();

        service.save(teacher);

        System.out.println("teacher的Java对象持久化到" +
                "关系数据库表teacher表成功!" +
                new Date().toString());
    }

    /**
     * 删除实验
     */
    public static void deleteTest(Integer id){

        Teacher teacher = null;

        TeacherService service = new TeacherService();

        teacher = service.get(id);

        if (teacher != null){
            service.delete(teacher);
        }

        System.out.println("数据库记录删除成功！");

    }

    /**
     * 修改实验
     */
    public static void updateTest(Integer id, Teacher t){

        Teacher teacher = null;

        TeacherService service = new TeacherService();

        teacher = service.get(id);

        if (teacher != null){

            teacher.setTname(t.getTname());
            teacher.setTno(t.getTno());
            teacher.setDept(t.getDept());
            teacher.setHireDate(t.getHireDate());
            teacher.setIntroduction(t.getIntroduction());

            service.update(teacher);

        }
        System.out.println("数据库记录更新成功！");


    }

    /**
     * get查询
     */
    public static void getTest(){

        Teacher teacherX = null;

        TeacherService service = new TeacherService();

        System.out.println("get查询");

        for (int i = 1;i <= 5;i++){
            teacherX = service.get(1);
            System.out.println(teacherX.hashCode());
        }

        for (int i = 1;i <= 5;i++){
            teacherX = service.get(1);
            System.out.println(teacherX.toString());
        }

    }

    /**
     * load查询
     */
    public static void loadTest(){
        Teacher teacherX = null;

        TeacherService service = new TeacherService();

        System.out.println("load查询");

        for (int i = 1;i <= 5;i++){
            teacherX = service.load(1);
            System.out.println(teacherX.hashCode());
        }

        for (int i = 1;i <= 5;i++){
            teacherX = service.load(1);
            System.out.println(teacherX.toString());
        }
    }
}
