package com.iss.controller;

import com.google.gson.Gson;
import com.iss.dao.IBook;
import com.iss.po.Books;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.swing.*;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@WebServlet("/demoServlet")
public class demoServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Gson gson=new Gson();
        SqlSession sqlSession= DBUtil.getSession();
        IBook iBook=sqlSession.getMapper(IBook.class);
        List<Books> list=iBook.getAllBook();
        response.getWriter().append(gson.toJson(list));
    }
}
