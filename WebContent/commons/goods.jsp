<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/goods.css" />
		<title>商品展示</title>
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
				<li class="h2-1"><a href="${pageContext.request.contextPath}/commons/personal.jsp">个人中心</a></li>
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
				<div class="s1">
				<img height="130px" width="100%" src="${pageContext.request.contextPath}/img/images/product.gif" />	
				</div>
				<div class="x1">
					<div class="l2">
						<div class="l3">
							<a href="#"><img width="350px" height="350px" src="${pageContext.request.contextPath}/img/images/animal.jpg" /></a>
						</div>
						<div class="r3">
							<ul>
								<li class="h5">
									<a href="#">
										<img width="50px" height="50px" src="${pageContext.request.contextPath}/img/images/1.jpg" />
									</a>
								</li>
								<li class="h5">
									<a href="#">
										<img width="50px" height="50px" src="${pageContext.request.contextPath}/img/images/2.jpg" />
									</a>
								</li>
								<li class="h5">
									<a href="#">
										<img width="50px" height="50px" src="${pageContext.request.contextPath}/img/images/3.jpg" />
									</a>
								</li>
								<li class="h5">
									<a href="#">
										<img width="50px" height="50px" src="${pageContext.request.contextPath}/img/images/4.jpg" />
									</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="r2">
						<div class="s2">
							<ul>
							<li>
							<%-- <c:forEach items="${page.records}" var="b"> --%>
						<%-- 	<h3>商品名：${b.name}<br/>
    							二级标题：${b.subTitle}<br/> --%>
							<a href="#">小款铁艺圣诞麋鹿摆件 <br>
							圣诞节装饰品 圣诞树装饰 圣诞鹿</a></h3>	
							</li>
							<li>
								<span class="h6-1">价格</span>
							<%-- 	原价：${b.orignalPrice}<br/>
    							售价：${b.promotePrice}<br/> --%>
								<div class="h6-2">
								<em >¥</em>
								<em ><a href=""></a></em>
								</div>
							</li>
							</ul>
						</div>
						<div class="s3">
							<dl>
								<dt>商品属性</dt>
								<dd class="h8-1">
									<ul>
										<li class="h7-1">
											<a href=""><span>小号25*15cm银色</span></a>
										</li>
										<li class="h7-1">
											<a href=""><span>小号25*15cm红色</span></a>
										</li>
										<li class="h7-1">
											<a href=""><span>中号35*25cm银色</span></a>
										</li>
										<li class="h7-1">
											<a href=""><span>中号35*25cm红色</span></a>
										</li>
										<li class="h7-1">
											<a href=""><span>大号50*35cm红色</span></a>
										</li>
									</ul>
								</dd>
								<dt>数量</dt>
								<dd class="h8-2">
									<span>
										<a href="#">-</a>
										<input  type="text" value="1" />
										<input style="width: 30px;height: 20px;" type="text" size="3" id="number" name="number"
					value="${me.value.number}"
					onchange="changeNumber(this,'${me.value.number}','${me.key}')" />
										<a href="#">+</a>  件(库存剩余<a href="">10</a>件)
									</span>
								</dd>
							</dl>	
							
					<%-- 		+${sessionScope.cart.id} --%>
							<div class="s4">
								<button style="width: 100px;height: 40px;" class="h8-4">
								<a href="${pageContext.request.contextPath}/ClientServlet?op=showOrders&productId=+${sessionScope.cart.id}">
    				生成订单 </a>
								</button>
								<button style="width: 150px;height: 40px;" class="h8-4" >
								<a href="${pageContext.request.contextPath}/ClientServlet?op=buyProducts&productId=2">
    				加入购物车 </a></button>
							</div>
							<%-- </c:forEach> --%>
							<dl class="s5">
								<dt>承诺</dt>
								<dd class="h9-8">
									<img src="${pageContext.request.contextPath}/img/images/5.jpg" /> 7天无理由退款
								</dd>
								<dt>支付</dt>
								<dd class="h9-8">
									<img src="${pageContext.request.contextPath}/img/images/6.png" /> 信用卡支付
								</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
			
		
		
		</div>
		<%--     <table>

    	<tr>
    	
    		<c:forEach items="${page.records}" var="b">
    			<td>
    				<img src="${pageContext.request.contextPath}/img/${b.path}/${b.filename}"/><br/>
    				
    				商品名：${b.name}<br/>
    				二级标题：${b.subTitle}<br/>
    				原价：${b.orignalPrice}<br/>
    				售价：${b.promotePrice}<br/>
    				库存：${b.stock}<br/>
    				创建时间：${b.createDate}<br/>
    				评论数量：${b.reviewCount}<br/>
    				销售数量：${b.saleCount}<br/>
    				
    				<a href="${pageContext.request.contextPath}/ClientServlet?op=buyProducts&productId=1">
    			放入购物车</a>
				   	<a href="${pageContext.request.contextPath}/ClientServlet?op=showReviews&productId=${b.id}">
				   	点击查看用户评论</a>
				   	
			   	    <c:if test="${empty beans}">
    				该商品没有任何评论
    				</c:if>
    				<c:if test="${!empty beans}">
	    				<c:forEach items="${beans}" var="rv" varStatus="vs">
			    			<tr class="${vs.index%2==0?'even':'odd'}">
				    			<td>${rv.id}</td>
				    			<td>${rv.content}</td>
				    			<td>${rv.createDate}</td>
				    		</tr>
	    				</c:forEach>
    			 	</c:if>
    			</td>
    			
    		</c:forEach>
    	</tr>	
    </table>	
  --%>
		
	</body>
</html>
