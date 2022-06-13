package com.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserDao_JdbcTemplate implements IUserDao{
    private JdbcTemplate jdbcTemplate;
    //事务管理所需要的两个类
    private DataSourceTransactionManager transactionManager;
    private DefaultTransactionDefinition def;

    public void setDataSource(DruidDataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        transactionManager= new DataSourceTransactionManager(dataSource);
        def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);
        def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        def.setTimeout(-1);
        def.setReadOnly(false);
    }
    @Override
    public void insert(C8User user) throws SQLException {
        String name = user.getName();
        String age = user.getAge();
        jdbcTemplate.update("insert into user(name,age) value (?,?)",new Object[]{name,age});
        System.out.println("JdbcTemplate insert success!!");
    }

    @Override
    public void insert2Users(C8User user1, C8User user2) {
        String name1 = user1.getName();
        String age1 = user1.getAge();
        String name2 = user2.getName();
        String age2 = user2.getAge();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            String sqlToInsert="insert into user(name,age) values (?,?)";
            jdbcTemplate.update(sqlToInsert,new Object[]{name1,age1});
            jdbcTemplate.update(sqlToInsert,new Object[]{name2,age2});
            System.out.println("JdbcTemplate insert success!!");
        } catch (Exception e) {
            transactionManager.rollback(status);
            e.printStackTrace();
        }
        transactionManager.commit(status);

    }

    @Override
    public C8User find(int id) {
        List list = jdbcTemplate.queryForList("select * from user where id = ?",id);
        Iterator it = list.iterator();
        if(it.hasNext()){
            Map map = (Map)it.next();
            int id1 = Integer.parseInt(map.get("id").toString());
            String name = map.get("name").toString();
            String age = map.get("age").toString();
            C8User c8User = new C8User();
            c8User.setId(id1);
            c8User.setName(name);
            c8User.setAge(age);
            return c8User;
        }
        return null;
    }


}
