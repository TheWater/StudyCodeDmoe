package org.example.dao;

import org.example.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @package:org.example.dao
 * @class:StudentDAOImpl
 * @description:// TODO
 * @author: zzw
 * @date:2022/5/3 20:12
 */
public class StudentDAOImpl implements StudentDAO{

    private static SessionFactory sessionFactory;

    /**
     * 初始化Hibernate,创建SessionFactory实例
     */
    static{
        // 创建标准服务注册器
        StandardServiceRegistry standardServiceRegistry = new
                StandardServiceRegistryBuilder().configure().
                build(); // 加载XML格式的Hibernate配置文件hibernate.cfg.xml
        try{
            // 创建代表映射元数据的MetaData对象
            Metadata metadata = new MetadataSources(standardServiceRegistry).
                    buildMetadata();
            // 创建SessionFactory对象
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }catch (RuntimeException e){
            // 销毁标准服务注册器
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            e.printStackTrace();
            throw e;
        }
    }

    // 增加
    @Override
    public void saveStudent(Student student) {
        // 1.返回session对象
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            // 2.开启事务
            transaction = session.beginTransaction();
            // 3.使用session对象进行持久化操作
            session.save(student);
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

    }

    // 删除
    @Override
    public void deleteStudent(Student student) {
        // 1.返回session对象
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            // 2.开启事务
            transaction = session.beginTransaction();
            // 3.使用session对象进行持久化操作
            session.delete(student);
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
    }

    // 修改
    @Override
    public void updateStudent(Student student) {
        // 1.返回session对象
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            // 2.开启事务
            transaction = session.beginTransaction();
            // 3.使用session对象进行持久化操作
            session.update(student);
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
    }

    // load查询
    @Override
    public Student loadStudent(Integer id) {

        Student student = null;
        // 1.返回session对象
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            // 2.开启事务
            transaction = session.beginTransaction();
            // 3.使用session对象进行持久化操作
            student = session.load(Student.class, id);

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
        return student;
    }



    // get查询
    @Override
    public Student getStudent(Integer id) {

        Student student = null;
        // 1.返回session对象
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            // 2.开启事务
            transaction = session.beginTransaction();
            // 3.使用session对象进行持久化操作
            student = session.get(Student.class, id);

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
        return student;
    }
}
