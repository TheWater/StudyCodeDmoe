package com.dao;

import java.sql.SQLException;

public interface IUserDao {
    public void insert(C8User user) throws SQLException;
    public void insert2Users(C8User user1,C8User user2);
    public C8User find(int id);
}
