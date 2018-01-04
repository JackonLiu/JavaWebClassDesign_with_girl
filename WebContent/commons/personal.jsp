<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/personal.css" />
		<title></title>
	</head>
	<body>
		<div class="menu">
			<article class="s">
				<div class="logo4">
				<img width="80px" height="80px" 
				src="${pageContext.request.contextPath}/img/images/orange.jpg" />
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
				<aside class="l2">
				<h3>全部功能</h3>
					<ul>
						<li class="h5"><a href="${pageContext.request.contextPath}/commons/showCart.jsp">我的购物车</a></li>
						<li class="h6"><a href="${pageContext.request.contextPath}/commons/data.jsp">个人资料</a></li>
						<li class="h6"><a href="${pageContext.request.contextPath}/ClientServlet?op=showOrders&productId=${b.id}">
    				我的订单 </a></li>
						<li class="h7"><select>
							<option>退款管理</option>
							<option>售后管理</option>
							<option>投诉管理</option>
							<option>举报管理</option>
						</select></li>
					</ul>
				</aside>
				<div class="r2">
					<!--
                    	右部分
                    -->
                    <div class="s1">
                    	<!--
                        	上部分
                        -->
                        <div class="s2">
                        	<nav class="l3">
                        	<ul>
                        	<li class="h8-1">
                        	<img width="50px" height="50px" src="${pageContext.request.contextPath}/img/images/one.jpg" />	
                        	</li>	
                        	<li class="h8-2"><a href="">用户名</a></li>
                        	</ul>
                        	</nav>
                        </div>
                        <div class="x2">
                        	<nav class="r3">
                        	<ul>
                        		<li class="h9-1"><a href="">待付款</a></li>
                        		<li class="h9-2"><a href="">待发货</a></li>
                        		<li class="h9-3"><a href="">待收货</a></li>
                        		<li class="h9-4"><a href="">待评价</a></li>
                        		<li class="h9-5"><a href="">退款</a></li>
                        	</ul>
                        	</nav>
                        </div>
                    </div>
                   
                   <div class="x1">
                    	<!--
                        	下部分
                        -->
                        <div class="a1">
                        <div class="a1-1"><img  width="50px" height="50px" src="${pageContext.request.contextPath}/img/images/mydelivery.jpg"/></div>
                        <div class="a1-2">我的物流</div>
                        </div>
                        <div class="a2">
                        	<ul>
                        		<li class="c1">
                        			<div class="a2-1">
                        				<img width="40ox" height="40px" src="${pageContext.request.contextPath}/img/images/smallanmial.jpg" />
                        			</div>
                        			<div class="a2-2"><a href="">圣诞工艺小鹿的物流</a></div>
                        			<div class="a2-3">
                        				<button class="b1">确定收货</button>
                        			</div>
                        		</li>
                        		<li class="c1">
                        			<div class="a2-1">
                        				<img width="40ox" height="40px" src="${pageContext.request.contextPath}/img/images/smallanmial.jpg" />
                        			</div>
                        			<div class="a2-2"><a href="">圣诞工艺小鹿的物流</a></div>
                        			<div class="a2-3">
                        				<button class="b1">确定收货</button>
                        			</div>
                        		</li>
                        	</ul>
                        </div>
     <%--                    <div class="a3">
                       <h1>您的订单信息如下</h1>
					    <c:if test="${empty orders}">
					    	您还没有购买任何商品
					    </c:if>
					    <c:if test="${!empty orders}">
					    	<table border="1" width="638">
					    		<tr>
					    			<th>订单号</th>
					    			<th>订单金额</th>
					    			<th>数量</th>
					    			<th>状态</th>
					    			<th>操作</th>
					    		</tr>
					    		<c:forEach items="${orders}" var="o" varStatus="vs">
					    			<tr class="${vs.index%2==0?'even':'odd'}">
						    			<td>${o.ordernum}</td>
						    			<td>${o.price}</td>
						    			<td>${o.number}</td>
						    			<td>
						    				<c:choose>
						    					<c:when test="${o.status==0}">
						    						未付款
						    					</c:when>
						    					<c:when test="${o.status==1}">
						    						已付款
						    					</c:when>
						    					<c:otherwise>
						    						有待开发
						    					</c:otherwise>
						    				</c:choose>
						    			</td>
						    			<td>
						    				<c:choose>
						    					<c:when test="${o.status==0}">
						    						<a href="${pageContext.request.contextPath}/commons/pay.jsp?ordernum=${o.ordernum}&price=${o.price}">付款</a>
						    					</c:when>
						    					<c:when test="${o.status==1}">
						    						跟踪
						    					</c:when>
						    					<c:otherwise>
						    						有待开发
						    					</c:otherwise>
						    				</c:choose>
						    			</td>
						    		</tr>
					    		</c:forEach>
					    	</table>
					    </c:if>
                        </div> --%>
                    </div>
				</div>
			</div>
		</div>
	</body>
</html>
