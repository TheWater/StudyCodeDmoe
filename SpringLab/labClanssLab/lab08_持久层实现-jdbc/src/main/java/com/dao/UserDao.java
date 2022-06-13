package com.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao implements IUserDao{
    private DataSource dataSource;
    // DataSource注入
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(C8User user){
        String name = user.getName();
        String age = user.getAge();
        Connection conn=null;
        PreparedStatement stmt =null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("insert into user(name,age) value (?,?)");
            stmt.setString(1,name);
            stmt.setString(2,age);
            int i =stmt.executeUpdate();
            if(i>0){
                System.out.println("Insert success!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }



    }

    @Override
    public void insert2Users(C8User user1, C8User user2) {

    }

    @Override
    public C8User find(int id) {
        return null;
    }
}
