package com.neuedu.dao;

import com.neuedu.dataSource.DruidDataSource;
import com.neuedu.pojo.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner qr=null;
    private DruidDataSource dds=DruidDataSource.getDds();

    public UserDaoImpl()
    {
        //构造器初始化QuerryRunner对象
        qr=new QueryRunner();
    }

    @Override
    public List<User> getAllUser() {
        String sql="SELECT * FROM user";
        List<User> list=null;
        Connection conn=dds.getConnection();
        try {
           list= qr.query(conn,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
