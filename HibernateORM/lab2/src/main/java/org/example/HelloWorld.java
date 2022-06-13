package org.example;

import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * @package:PACKAGE_NAME
 * @class:HelloWorld
 * @description:// 请参考StudentDemo使用
 * @author: zzw
 * @date:2022/4/24 11:37
 */
public class HelloWorld {

    public static void main(String[] args){
        // 1.加载hibernate.cfg.xml配置文件
        Configuration configuration = new Configuration().configure();
        // 2.新建sessionFactory对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.返回session对象
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction transaction = session.beginTransaction();
        // 5.使用session对象进行持久化操作
        Teacher teacher = new Teacher(8888, "李四", "2040111112",
                "软件工程系", new Date(), "123456789147258360");
        session.save(teacher);
        transaction.commit();
        System.out.println("teacher对象持久化到关系数据库myhibernate的teacher数据表成功！");

    }

}
