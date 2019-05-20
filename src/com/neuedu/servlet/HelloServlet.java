package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoIpml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns="/hello.to")
public class HelloServlet extends HttpServlet {
    private UserDao ud;
    //初始化servlet
    @Override
    public void init() throws ServletException {
    ud=new UserDaoIpml();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("<h1>hello</h1>");
        String user=request.getParameter("username");
        String psw=request.getParameter("psw");
        ud.register(user,psw);
        //跳转界面
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
