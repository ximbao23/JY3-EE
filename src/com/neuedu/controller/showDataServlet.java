package com.neuedu.controller;

import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "showDataServlet",urlPatterns = "/show.do")
public class showDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id= request.getParameter("id");
    String username= request.getParameter("username");
    String psw= request.getParameter("psw");
    int id1=Integer.parseInt(id);
    User user=new User(username,psw,id1);
    request.setAttribute("user",user);
    request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
