package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoIpml;
import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud=new UserDaoIpml();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getParameter("username");
       String psw= request.getParameter("psw");

        User user1=ud.login(new User(user,psw));
        if(null!=user1)
        {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
