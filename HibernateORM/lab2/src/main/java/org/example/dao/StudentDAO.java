package org.example.dao;

import org.example.pojo.Student;

import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student);
    void deleteStudent(Student student);
    void updateStudent(Student student);

    Student loadStudent(Integer id);
    Student getStudent(Integer id);

}
