<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.luke.cart.bean.CartItem" %>
<%@ page import="com.luke.cart.bean.Cart" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>

  </head>
  
  <body>
<h1>购物车</h1>
<%
  String msg = (String) request.getAttribute("msg");
	if (msg!=null&&!msg.isEmpty()){
		request.setAttribute("msg",msg);
	}
%>
<p style="color: rgba(255, 29, 19, 0.99)">${msg}</p>
<table border="1" width="100%" cellspacing="0" background="black">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="<c:url value='/clear?Method=clearAll'/>">清空购物车</a>
		</td>
	</tr>
	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
<c:forEach  var="cart" items="${sessionScope.cartList}">
	<tr>
		<td>
            <div>
                <img src="<c:url value='/${cart.book.image}'/>"/>
            </div>
        </td>
		<td>${cart.book.bname}</td>
		<td>${cart.book.author}</td>
		<td>${cart.book.price}元</td>
		<td>${cart.count}元</td>
		<td>
        <fmt:formatNumber type="number"
             value="${(cart.book.price*cart.count)}"
                          maxFractionDigits="2"/>
        </td>
		<td><a href="<c:url value='/clear?bid=${cart.book.bid}&Method=delete'/>">删除</a></td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			合计：<fmt:formatNumber type="number"
								 value="${(sessionScope.money)}"
								 maxFractionDigits="2"/>元
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="<c:url value="/order?money=${sessionScope.money}&Method=addOneOrder"/>" ></a>
		</td>
	</tr>
</table>
  </body>
</html>
