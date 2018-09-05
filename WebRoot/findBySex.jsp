<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findBySex.jsp' starting page</title>
    
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
  <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
  <script type="text/javascript">
  function find( op ){
  	$.ajax({
  		data:"sex="+op,
  		dataType:"json",
  		type:"post",
  		url:"user/findUsersBySex.do",
  		success:function( data){
  			var str="<table>";
  			for(var i=0;i<data.length;i++){
  				var user=data[i];
  				str+="<tr><td>"+user.name+"</td><td>"+user.address+"</td></tr>"
  			}
  			str+="</table>"
  			$("#name").html(str);
  			
  		},
  		error:function(){
  			alert("error")
  		}
  	});
  }
  </script>
    请选择性别 <input type="radio" name="sex" value="男" onclick="find(this.value)">男<input type="radio" name="sex" value="女" onclick="find(this.value)">女<br>
 
   	<div id="name"></div>

  </body>
</html>
