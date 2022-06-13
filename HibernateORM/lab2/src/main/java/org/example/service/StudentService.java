package org.example.service;

import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @package:org.example.service
 * @class:StudentService
 * @description:// TODO
 * @author: zzw
 * @date:2022/4/24 13:43
 */
public class StudentService {

    private StudentDAO dao = new StudentDAOImpl();

    /**
     * 持久化一个Student对象
     *
     */
    public void save(Student student){
        dao.saveStudent(student);
    }

    public void delete(Student student) {
        dao.deleteStudent(student);
    }

    public void update(Student student) {
        dao.updateStudent(student);
    }

    public Student get(Integer id) {
        return dao.getStudent(id);
    }

    public Student load(Integer id) {
        return dao.loadStudent(id);
    }

}
