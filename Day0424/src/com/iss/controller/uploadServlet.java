package com.iss.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

/**
 * @Author By gaojiaming1227@gmail.com Employer Gao
 * @date 2019/4/24
 */
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String path="";
        String str="";
        try {
            //物理文件存放路径
            path=getServletContext().getRealPath("/uploads");


            //定义一个文件对象
            File tempFile=new File(path);

            tempFile.mkdir();//需要手动创建目录

            DiskFileItemFactory factory=new DiskFileItemFactory();


            //设定临时存放路径
            factory.setRepository(tempFile);

            //设置单次文件读取大小
            factory.setSizeThreshold(1024*1024);//1k

            //根据文件工厂，上传文件
            ServletFileUpload upload=new ServletFileUpload(factory);

            upload.setHeaderEncoding("UTF-8");
            upload.setFileSizeMax(1024*1024*10);//单个文件最大10M
            upload.setSizeMax(1024*1024*10);//一批上传的文件，不能大于10M

            //接受客户端上传的文件列表
            List<FileItem> formItems=upload.parseRequest(request);


            //处理上传文件
            for (FileItem item:formItems) {
                String id= UUID.randomUUID().toString().replace("-","");
                File f=new File(item.getName());

                String newFileName=id+item.getName().split("\\.")[1];

                File storeFile=new File(path+"\\"+id);
                item.write(storeFile);
            }

            str="上传成功！";
        } catch (Exception e) {
            str=e.getMessage();
            e.printStackTrace();
        }
        out.print(str);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
