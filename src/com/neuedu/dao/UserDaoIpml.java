package com.neuedu.dao;

import com.mysql.jdbc.Driver;
import com.neuedu.pojo.User;
import com.neuedu.utils.DBUtils;

import java.sql.*;

public class UserDaoIpml implements UserDao {




    @Override
    public void register(String user, String psw) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            String str = "INSERT INTO User (username,psw) VALUES (?,?)";
            ps = conn.prepareStatement(str);
            ps.setString(1, user);
            ps.setString(2, psw);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          DBUtils.closePstm(ps);
          DBUtils.closeConnection(conn);

        }
    }

    @Override
    public User login(User user) {
        Connection conn=DBUtils.getConnection();
        String sql="SELECT username,psw FROM user WHERE username=? AND psw=?";
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            if(rs.next())
            {
               return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeResultSet(rs);
            DBUtils.closePstm(ps);
            DBUtils.closeConnection(conn);
        }

        return null;
    }
}
