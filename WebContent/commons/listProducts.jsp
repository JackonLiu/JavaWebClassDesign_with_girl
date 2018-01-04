<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

<title>橙子商城</title>
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shangdian.css" />
</head>

<body>
	<div class="h1" style="margin-top: 40px;">
   	商品分类：
    <c:forEach items="${cs}" var="c">
    	<a href="${pageContext.request.contextPath}/ClientServlet?op=listProductByCategory&categoryId=${c.id}">${c.name}
    	</a>&nbsp;&nbsp;&nbsp;
    </c:forEach>
    </div>
	<div class="h2">
	<form
		action="${pageContext.request.contextPath}/ClientServlet?op=listProductByCategory"
		method="post" id="form1">
		<table width="100px">
			<tr>
				<td><b>Search</b></td>
				<td><input type="text" name="categoryId"/></td>
				<td>
					<input type="submit" value="搜索" style="background: aquamarine;"/> 
				</td>
			</tr>
		</table>
		</form>
	</div>

	<!--下部分-->
	<div class="menu">
		<div class="h3-1" style="float: left;">
			<!--第一行-->
			<div class="h3-2">
				<p>超市必买SELECTED</p>
			</div>
			<!--第二行-->
			<div class="h3-9">
				<!--第一列-->
				<div class="h3-3">
					<table>
						<tr>
							<td><a href=""><img width="280px" height="420px"
									src="${pageContext.request.contextPath}/img/images/paper.jpg" /></a>
							</td>
							<!-- <td><a href="">今日疯抢</a></td> -->
						</tr>
					</table>
				</div>
				<!--第二列-->
				<div class="h3-4">
					<table>
						<tr>
							<td><a href="">有好货</a></td>
							<td><a href=""><img width="200px" height="200px"
									src="${pageContext.request.contextPath}/img/images/chocolate.jpg" /></a>
							</td>
						</tr>
						<tr>
							<td><a href="">量贩装</a></td>
							<td><a href=""><img width="200px" height="200px"
									src="${pageContext.request.contextPath}/img/images/milk.jpg" /></a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="h3-10" style="float: right;">
			<div class="h3-8">
				<p>品牌精选SHOWTIME</p>
			</div>
			<div class="h3-7">
				<table width="650px" height="420px" border="1px"
					style="border: 1px solid #FFFFFF;">
					<tr bgcolor="#FF7F50" height="40px" align="center">
						<td colspan="5" style="color: white;">店长推荐</td>
					</tr>
					<tr align="center">
					<c:forEach items="${page.records}" var="b">
						<td>
						  <c:if test="${!empty b.firstProductImage}">
						  <a href="${pageContext.request.contextPath}/ClientServlet?op=listProductByCategory&categoryId=${c.id}">
                            <img width="100px"  height="100px" src="${pageContext.request.contextPath}/img/images/${b.firstProductImage.type}.jpg">
                        </a>
                        </c:if>
						</br><a href="${pageContext.request.contextPath}/ClientServlet?op=listProductByCategory&categoryId=${c.id}">${b.name}</a>
						</td>
					</c:forEach>
					</tr>
							<tr align="center">
					<c:forEach items="${page.records}" var="b">
						<td>
						  <c:if test="${!empty b.firstProductImage}">
						  <a href="${pageContext.request.contextPath}/ClientServlet?op=listProductByCategory&categoryId=${c.id}">
                            <img width="100px"  height="100px" src="${pageContext.request.contextPath}/img/images/${b.firstProductImage.type}.jpg">
                        </a>
                        </c:if>
						</br><a href="${pageContext.request.contextPath}/ClientServlet?op=listProductByCategory&categoryId=${c.id}">${b.name}</a>
						</td>
					</c:forEach>
					</tr>
						<%-- <td><a href=""><img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/yilingjin.jpg" /></a>
						</br><a href="">蓝月亮衣领净</a></td>
						<td><a href=""><img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/jiangzhonghougu.jpg" /></a>
						</br><a href="">江中猴菇饼干</a></td>
						<td><a href=""><img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/huashengyou.jpg" /></a>
						<a href="">鲁花一级花生油</a></td>
					
					<tr align="center">
						<td><a href=""><img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/lajidai.jpg" /></a>
						<a href="">利得背心垃圾袋</a></td>
						<td><a href=""><img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/yusan.jpg" /></a>
						<a href="">日本进口胶囊雨伞</a></td>
						<td><a href="${pageContext.request.contextPath}/commons/goods.jsp?${b.id}"><img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/smallanmial.jpg" /></a>
						<a href="${pageContext.request.contextPath}/commons/goods.jsp">圣诞工艺品小鹿</a></td>
						<td><a href="">
						<img width="100px" height="100px"
								src="${pageContext.request.contextPath}/img/images/xiaoqingmang.jpg" /></a>
						<a href="">广西小青芒</a></td>
					</tr> --%>
				</table>

			</div>

		</div>
		
	</div>
  </body> 
</html>
 <%--  <%@ include file="/commons/page.jsp"%> --%>