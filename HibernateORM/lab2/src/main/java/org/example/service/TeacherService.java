package org.example.service;

import org.example.dao.TeacherDAO;
import org.example.dao.TeacherDAOImpl;
import org.example.pojo.Teacher;

/**
 * @package:org.example.service
 * @class:StudentService
 * @description:// TODO
 * @author: zzw
 * @date:2022/4/24 13:43
 */
public class TeacherService {

    private TeacherDAO dao = new TeacherDAOImpl();

    /**
     * 持久化一个Student对象
     *
     */
    public void save(Teacher teacher){
        dao.saveTeacher(teacher);
    }

    public void delete(Teacher teacher) {
        dao.deleteTeacher(teacher);
    }

    public void update(Teacher teacher) {
        dao.updateTeacher(teacher);
    }

    public Teacher get(Integer id) { return dao.getTeacher(id);
    }

    public Teacher load(Integer id) {
        return dao.loadTeacher(id);
    }

}
