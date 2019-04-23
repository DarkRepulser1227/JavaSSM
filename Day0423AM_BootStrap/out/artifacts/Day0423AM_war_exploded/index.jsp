<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/23
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="js/bootstrap-table/bootstrap-table.min.css"/>

    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table/bootstrap-table.min.js"></script>

    <script>
      $(function () {
          $("#tbresul").bootstrapTable({
              url:"bookServlet",//从哪里请求数据
              method:"post",
              contentType:"application/x-www-form-urlencoded;charset=UTF-8",
              pagination:true,//分页
              sidePagination:"server",
              columns:[
                  {field:'bname',title:"书名",halign:"center"},
                  {field:'author',title:"作者",halign:"center"},
                  {field:'price',title:"单价",halign:"center"},
                  {field:'press',title:"出版社",halign:"center"}
              ],
              responseHandler:function (res) {
                return{
                  "total":res.total,
                  "rows":res.rows
                }
              }

          });
      });
    </script>

  </head>
  <body>
    <!--<img src="VCServlet" alt="验证码">-->
    <div class="container">
      <div class="row col-md-12">
        <table id="tbresul"></table>
      </div>
    </div>
  </body>
</html>
