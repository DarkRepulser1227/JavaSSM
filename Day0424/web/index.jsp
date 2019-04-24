<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/24
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form method="post" action="uploadServlet" enctype="multipart/form-data">
      <input type="file" name="uploadFile">
      <input type="submit" value="上传"/>
    </form>
  </body>
</html>
