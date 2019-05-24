package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoImpl;
import com.neuedu.pojo.Product;
import com.neuedu.util.DateconvString;
import com.neuedu.util.FileAction;
import com.neuedu.util.ProId;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AddServlet",urlPatterns = "/add.do")
@MultipartConfig
public class AddServlet extends HttpServlet {
    private ProDao pd;

    @Override
    public void init() throws ServletException {
        pd=new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proName=request.getParameter("pro_name");
        String proPrice=request.getParameter("pro_price");
        Part file1 = request.getPart("file1");
        String realFilename = FileAction.uploadFile(file1);
        String proDes=request.getParameter("prodes");
        String proStock=request.getParameter("pro_stock");
        String proDate=request.getParameter("pro_date");
        String proCateId=request.getParameter("procateid");
        String proFactory=request.getParameter("pro_fac");
        Product product = new Product(ProId.getProId(),proName,Double.parseDouble(proPrice),realFilename,proDes,Short.parseShort(proStock), DateconvString.getStringConverDate(proDate),Short.valueOf(proCateId),proFactory);
        pd.addOneProduct(product);
        response.sendRedirect("success.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
