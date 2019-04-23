<%--
  Created by IntelliJ IDEA.
  User: Employer Gao
  Date: 2019/4/23
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
      <link rel="stylesheet" href="JS/bootstrap/css/bootstrap.min.css">
      <link rel="stylesheet" href="JS/bootstrap-table/bootstrap-table.min.css">

      <script src="JS/jquery/jquery.min.js"/>
      <script src="JS/bootstrap/js/bootstrap.js"/>
      <script src="JS/bootstrap-table/bootstrap-table.min.js"/>

      <script>
          $(function () {
             $("#tbresul").bootstrapTable({
                 url:"",//从哪里请求数据
                 method:"post",
                 contentType:"application/x-www-form-urlencode;charset=UTF-8",
                 columns:[
                     {field:'bname',title:"书名",halign:"center"},//后台数据库列名
                     {field:'author',title:"作者",halign:"center"},
                     {field:'price',title:"单价",halign:"center"},
                     {field:'press',title:"出版社",halign:"center"},
                 ]
             });
          });
      </script>
  </head>
  <body>
    <%--<img src="VCServlet" alt="验证码" title="看不清？点击换一张" onclick="location.href='index.jsp'">--%>
    <div class="container">
        <div class="row col-md-12">
            <table id="tbresul"></table>
        </div>
    </div>
  </body>
</html>
