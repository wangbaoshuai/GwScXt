<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="user/login.do" method="post">
   	
   	请输入登录名<input type="text" name="uname"><br>
   	请输入密码<input type="text" name="upass"><br>
   <!-- 	请输入生日<input type="text" name="birth"><br>
   	请输入年龄<input type="text" name="age"><br>
   	插入图片<input type="file" name="file"><br> enctype="multipart/form-data" -->
   	<input type="submit" value="登录">
   </form>
  </body>
</html>
