package org.example.service;

import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;

public class app {
    public static void main(String[] args) {
        //加载Hibernate 核心配置文件
        Configuration configuration=new Configuration().configure();
        //创建一个SessionFactory用来获取Session连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //创建实体类对象
        Student student = new Student();
        student.setName("TOM");
        student.setAge("21");
        Serializable save1 = session.save(student);
        System.out.println("新增一条学生信息，主键为"+save1);


        Student student1 = new Student();
        student1.setName("JACK");
        student1.setAge("21");
        Serializable save2 = session.save(student1);
        System.out.println("新增一条学生信息，主键为"+save2);

        Student student2=session.load(Student.class,save1);
        Student student3 = session.load(Student.class, save2);
        System.out.println("学号为："+student2.getId()+"的学生姓名是："+student2.getName()+",年龄为"+student2.getAge());
        System.out.println("学号为："+student3.getId()+"的学生姓名是："+student3.getName()+",年龄为"+student3.getAge());

        student.setId((int)save1);
        student1.setAge("26");
        session.update(student1);
        Serializable save3 = session.save(student1);
        Student student4=session.load(Student.class,save3);
        System.out.println("学号为："+student4.getId()+"的学生姓名是："+student4.getName()+",年龄为"+student4.getAge());

        Teacher teacher1 = new Teacher();
        teacher1.setTname("张三");
        teacher1.setTno("0967");
        teacher1.setDept("软件系");
        teacher1.setIntroduce("30");
        teacher1.setHireDate("2006-02-26");
        Serializable save_t1 = session.save(teacher1);
        System.out.println("增加一条老师信息，主键为："+save_t1);

        Teacher teacher2 = new Teacher();
        teacher2.setTname("张三");
        teacher2.setTno("0967");
        teacher2.setDept("软件系");
        teacher2.setIntroduce("30");
        teacher2.setHireDate("2006-02-26");
        Serializable save_t2 = session.save(teacher2);
        System.out.println("增加一条老师信息，主键为："+save_t2);

        Teacher load_1 = session.load(Teacher.class, save_t1);
        Teacher load_2 = session.load(Teacher.class, save_t2);
        System.out.println("工号："+load_1.getTno()+"/n姓名"+load_1.getTname()+"/n年龄"+load_1.getIntroduce()+"/n部门："+load_1.getDept()+"/n入职时间："+load_1.getHireDate());
        System.out.println("工号："+load_2.getTno()+"/n姓名"+load_2.getTname()+"/n年龄"+load_2.getIntroduce()+"/n部门："+load_2.getDept()+"/n入职时间："+load_2.getHireDate());

        teacher1.setId((Integer) save_t1);
        teacher1.setDept("电子系");
        session.update(teacher1);
        Serializable save = session.save(teacher1);
        Teacher load_t3 = session.load(Teacher.class, save);
        System.out.println("修改后"+load_t3.getTname()+"部门为"+load_t3.getDept());

        Teacher t = session.load(Teacher.class, save_t2);
        session.delete(t);
        Teacher loadc = session.load(Teacher.class, save_t2);
        System.out.println(loadc);



        //提交事务
        transaction.commit();

        //释放资源
        session.close();
        sessionFactory.close();

    }
}
