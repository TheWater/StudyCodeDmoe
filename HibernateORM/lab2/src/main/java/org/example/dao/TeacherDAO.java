package org.example.dao;

import org.example.pojo.Teacher;

public interface TeacherDAO {

    void saveTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);

    Teacher loadTeacher(Integer id);
    Teacher getTeacher(Integer id);

}
