package com.iss.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author By gaojiaming1227@gmail.com Employer Gao
 * @date 2019/4/23
 */
@WebServlet("/VCServlet")
public class VCServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义验证码图像的大小
        int width = 200;
        int height = 65;

        //随机数生成器
        Random random = new Random();

        //在内存中创建图像对象
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //创建画笔对象
        Graphics graphics = img.getGraphics();

        //给画布添加背景色
        graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256 )));
        graphics.fillRect(1,1,width-2,height-2);

        //给边框添加颜色
        graphics.setColor(Color.yellow);
        graphics.drawRect(0,0,width-1,height-1);

        //给字体添加颜色和样式
        graphics.setColor(Color.cyan);
        graphics.setFont(new Font("Consolas",Font.BOLD|Font.ITALIC,30));

        //给图片添加随机数

        int pos=40;
        for (int i = 0;i<4;i++){
            graphics.drawString(random.nextInt(10)+"",pos,40);
            pos+=30;
        }

        //添加干扰线
        for (int i = 0;i < 30;i++){
            graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256 )));
            graphics.drawLine(random.nextInt(width),random.nextInt(height),random.nextInt(width),random.nextInt(height));
        }

        ImageIO.write(img,"png",response.getOutputStream());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
