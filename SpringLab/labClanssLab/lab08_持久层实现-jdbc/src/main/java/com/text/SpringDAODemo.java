package com.text;

import com.dao.C8User;
import com.dao.IUserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class SpringDAODemo {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        C8User user = new C8User();
//        user.setName("Tom");
//        user.setAge("18");
//
//        IUserDao userDao = context.getBean("userDao", IUserDao.class);
//        userDao.insert(user);
//        System.out.println("用户信息"+user.getName()+","+user.getAge());
//
//
//        IUserDao userDaoTemplate = context.getBean("userDaoTemplate", IUserDao.class);
//        user = userDaoTemplate.find(18);
//        System.out.println("用户信息"+user.getName()+","+user.getAge());
        //配置要添加的两个user对象
        C8User user1 = new C8User();user1.setName("TOM");user1.setAge("20");
        C8User user2 = new C8User();user2.setName("JACK");user2.setAge("30");
        //获取dao层的bean对象
        IUserDao userDao = context.getBean("userDaoTemplate", IUserDao.class);
        userDao.insert2Users(user1,user2);


    }
}
