<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/29
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是一个登录页面
<form action="../checklogin.data" method="get">
    username:<input type="text" name="username" value="admin"/><br/><br/>
    password:<input type="text" name="password" value="123456"/><br/><br/>
    username:<input type="submit" value="提交"/>
</form>
</body>
</html>
