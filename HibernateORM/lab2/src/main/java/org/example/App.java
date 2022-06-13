package org.example;

import org.example.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;

/**
 * 请参考StudentDemo使用
 */
public class App 
{

    private static SessionFactory sessionFactory;
    // 初始化Hibernate,创建SessionFactory实例
    static{
        // 创建标准服务注册器
        StandardServiceRegistry standardServiceRegistry = new
                StandardServiceRegistryBuilder().configure().
                build(); // 加载XML格式的Hibernate配置文件hibernate.cfg.xml
        try{
            // 创建代表映射元数据的MetaData对象
            Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
            // 创建SessionFactory对象
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }catch (RuntimeException e){
            // 销毁标准服务注册器
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            e.printStackTrace();
            throw e;
        }
    }



    public static void main( String[] args ) {

        System.out.println( "2022 Hello World!" );

        Student student1 = new Student(8080,"2140123456","tom",21);
        Student student2 = new Student(8080, "2040129125", "Jack", 19);


        // 1.返回session对象
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            // 2.开启事务
            transaction = session.beginTransaction();
            // 3.使用session对象进行持久化操作
            Serializable save1 = session.save(student1);
            Serializable save2 = session.save(student2);

            student1=session.load(Student.class,save1);
            student2 = session.load(Student.class, save2);
            System.out.println("学号为："+student2.getId()+"的学生姓名是："+student2.getName()+",年龄为"+student2.getAge());
            System.out.println("学号为："+student1.getId()+"的学生姓名是："+student1.getName()+",年龄为"+student1.getAge());

            student1.setId((int)save1);
            student1.setAge(26);
            session.update(student1);
            Serializable save3 = session.save(student1);
            student1=session.load(Student.class,save3);
            System.out.println("学号为："+student1.getId()+"的学生姓名是："+student1.getName()+",年龄为"+student1.getAge());
            // 4.提交事务
            transaction.commit();
        }catch (RuntimeException e){
            if (transaction != null){
                transaction.rollback();
            }
            throw e;
        }finally{
            session.close();
        }



        System.out.println("student对象持久化到关系数据库myhibernate的student数据表成功！");

    }
}
