package com.neuedu.dao;

import com.neuedu.pojo.User;

public interface UserDao {
    //注册
    void register(String user,String psw);
    //登录
    User login(User user);
}
