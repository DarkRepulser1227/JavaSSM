package com.iss.controller;

import com.google.gson.Gson;
import com.iss.dao.IBooks;
import com.iss.po.Books;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/bookServlet")
public class bookServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //建立连接;
        SqlSession sqlSession=DBUtil.getSession();
        //建立dao层反射;
        IBooks iBooks=sqlSession.getMapper(IBooks.class);
        Gson gson=new Gson();
//        //将数据转成json格式;
//        String str=gson.toJson(iBooks.getAllBook());
//        //向前台返回;
//        response.getWriter().append(str);
        //因分页需获取前端分页 只有
        // pagination:true,
        // sidePagination:"server",
        //同时存在才会传回offset(偏移量or起始值),limit(页数显示数据最大值),
        int offset = Integer.parseInt(request.getParameter("offset"));
        int rows = Integer.parseInt(request.getParameter("limit"));
        //获取全部书的数量
        int total = iBooks.getBookCount();
        //按页数获取书的信息并形成list
        List<Books> list = iBooks.getBooksByPage(offset,rows);
        //因为只有map{K:V}形式,且V可以是数组形式,只有map形式的V数组可以对应前端的rows数组
        Map map = new HashMap();
        map.put("total",total);
        map.put("rows",list);
        response.getWriter().append(gson.toJson(map));
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
