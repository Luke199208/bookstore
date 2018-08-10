<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
	  <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	  <script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
	  <script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>

	  <script type="text/javascript">
		  function add() {
			  $(".error").text("");
			  var bool = true;
			  if(!$(":text[name=username]").val()) {
				  $("#usernameError").text("用户名称不能为空");
				  bool = false;
			  }
			  if(!$(":password[name=password]").val()) {
				  $("#passwordError").text("密码不能为空");
				  bool = false;
			  }
			  var pwd1 = document.getElementById("pwd1").value;
			  var pwd2 = document.getElementById("pwd2").value;
			  if(pwd1!=pwd2){
				  $("#affirmPasswordError").text("两次输入的密码不一致");
				  bool = false;
			  }

			  if(!$(":text[name=email]").val()) {
				  $("#emailError").text("email不能为空");
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
  <h1>注册</h1>
<p style="color: red; font-weight: 900">${msg}</p>
<form action="<c:url value="/register" /> " method="post">
	<input type="hidden" name="method" value="regist"/>
	用户名：&nbsp&nbsp<input type="text" name="username" value=""/>
	<label id="usernameError" class="error">&nbsp;</label><br/>
	密　码：&nbsp&nbsp<input type="password" name="password" id="pwd1"/>
	<label id="passwordError" class="error">&nbsp;</label><br/>
	确认密码: <input type="password" name="password2" id="pwd2"/>
	<label id="affirmPasswordError" class="error">&nbsp;</label><br/>
	邮　箱：&nbsp&nbsp<input type="text" name="email" value=""/>
	<label id="emailError" class="error">&nbsp;</label><br/>
	<input type="button" value="注册" onclick="add()"/>
	<input type="reset" value="重置">
</form>
  </body>
</html>
