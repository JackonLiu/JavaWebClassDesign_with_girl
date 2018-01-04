<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>橙子商城</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shangdian.css" />
</head>

<body>
	<div style="padding-bottom: 10px;">
		<div id='logo'>
			<img style="margin-left: 150px;" width="50px" height="50px"
				src="${pageContext.request.contextPath}/img/images/orange.jpg" />
		</div>
		<div class="head_logo1" style="float: right;">
			<!--上部分-->
			<table width="600px">
				<tr>
					<td><img
						src="${pageContext.request.contextPath}/img/images/cart.gif"
						style="margin-top: 5px; margin-left: 100px; float: left;" />
						<div class="h1-1">
							<a href="${pageContext.request.contextPath}/commons/showCart.jsp">
								购物车 </a> <a href="${pageContext.request.contextPath}/index.jsp">首页
							</a> <a href="${pageContext.request.contextPath}/commons/login.jsp">
								登录 </a> 
								<a href="${pageContext.request.contextPath}/commons/regist.jsp">
								新用户注册 </a>
								 <a href="${pageContext.request.contextPath}/commons/personal.jsp">个人中心 </a>
						</div></td>
				</tr>
			</table>
		</div>
	</div>