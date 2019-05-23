package com.neuedu.controller;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update.do")
public class UpdateServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id= request.getParameter("id");
        String username= request.getParameter("username");
        String psw= request.getParameter("psw");
        User user=new User(username,psw,Integer.parseInt(id));
        ud.updateUser(user);
        response.sendRedirect("user.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
