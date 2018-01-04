<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/data.css" />
		<title>个人资料</title>
	</head>
	<body>
		<div class="menu">
			<article class="s">
				<div class="logo4">
				<img width="80px" height="80px" src="${pageContext.request.contextPath}/img/images/orange.jpg" />
				</div>
				<nav class="r1">
				<ul class="l1">
				<li class="h1"><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>	
				<li class="h2"><a href="${pageContext.request.contextPath}/commons/showCart.jsp">购物车</a></li>
				</ul>
				<div class="h3">
					<table width="150px">
					<tr>
						<td><b>Search</b></td>
						<td><input type="text"/></td>
						<td><button class="h4">确定</button></td>
					</tr>
				</table>
				</div>
				</nav>
			</article>
			<div class="x">
				<div class="x1">
					<ul>
						<li class="h5-1">
							<a href="data.html">个人资料</a>
						</li>
						<li class="h5-2">基本资料</li>
					</ul>
				</div>
				<div class="x2">
					<p class="h6-1">亲爱的<a href="">名称</a>，请填写真实资料，方便朋友找到你哦！</p>
					<p class="h6-2">
						<label class="h6-3">
							<em>*</em>昵称：
						</label>
						<input type="text" style="width: 200px;height: 20px;" />
					</p>
					<span class="h6-4">
						*昵称填写须知:昵称不可重复
					</span>
					<p class="h6-2" >
						<label class="h6-5">姓名：</label>
						<input type="text" style="width: 200px;height: 20px;" />
					</p>
					<p class="h6-2">
						<label class="h6-3">
							<em>*</em>性别：
						</label>
						<input type="radio"/>女
						<input type="radio"/>男
					</p>
					<p>
						<label class="h6-3">
							<em>*</em>收货地址:
						</label>
						<ul class="h6-7">
							<li class="h6-8">
								<select class="h6-6">
								<option>湖南省</option>
								</select>
							</li>
							<li class="h6-9">
								<select class="h6-6">
								<option>长沙市</option>
								</select>
							</li>
							<li>
								<input type="text" style="width: 200px;height: 20px;" />	
							</li>
						</ul>	
					</p>
					<p class="h8-1">
						<button style="width: 50px;height: 30px;">保存</button>
					</p>
				</div>
			</div>
		</div>
	</body>
</html>
