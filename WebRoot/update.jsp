<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
   <form action="user/update.do" method="post" enctype="multipart/form-data">
   <input type="hidden" name="id" value="${user.id }">
   请输入真实姓名<input type="text" name="name"><br>
   请输入家庭住址<input type="text" name="address"><br>
   请输入手机号<input type="text" name="phone"><br>
  	请输入生日<input type="text" name="birth"><br>
   	请选择性别<input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女<br>
   	插入图片<input type="file" name="file"><br> 
   	<input type="submit" value="提交">
   </form>
  </body>
</html>
