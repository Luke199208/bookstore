<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
	  <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	  <script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
	  <script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
	  <script type="text/javascript">
		  function login() {
			  $(".error").text("");
			  var bool = true;
			  if(!$(":text[name=adminname]").val()) {
				  $("#adminnameError").text("管理员名称不能为空");
				  bool = false;
			  }
			  if(!$(":password[name=password]").val()) {
				  $("#passwordError").text("密码不能为空");
				  bool = false;
			  }
			  if(bool) {
				  $("form").submit();
			  }
		  }

	  </script>
	  <style type="text/css">
		  .error {color:red;}
	  </style>
  </head>
  
  <body>
<h1>管理员登录页面</h1>
<hr/>
  <p style="font-weight: 900; color: red">${msg }</p>
<form action="<c:url value="/admin?Method=login"/>" method="post">
	管理员账户：<input type="text" name="adminname" value=""/>
	<label id="adminnameError" class="error">&nbsp;</label><br/>
	密　　　码：<input type="password" name="password"/>
	<label id="passwordError" class="error">&nbsp;</label><br/>
	<input type="button" value="进入后台" onclick="login()"/>
</form>
  </body>
</html>
