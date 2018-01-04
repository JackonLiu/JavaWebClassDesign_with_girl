<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/shopbasket.css" />
<title>购物车</title>
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
					<li class="h2">
					<a href="${pageContext.request.contextPath}/commons/showCart.jsp">
					购物车</a></li>
					<li class="h2-1">
					<a href="${pageContext.request.contextPath}/commons/personal.jsp">
					个人中心</a></li>
				</ul>
				<div class="h3">
					<table width="150px">
						<tr>
							<td><b>Search</b></td>
							<td><input type="text" /></td>
							<td><button class="h4">确定</button></td>
						</tr>
					</table>
				</div>
			</nav>
		</article>

		<div class="x">
			<div class="s1">
				<h2 class="h5">全部商品</h2>
			</div>
			<div class="x1">
				<div class="h6">
					<ul>
						<li class="h6-1"><input type="checkbox" />全选</li>
						<li class="h6-3">商品信息</li>
						<li class="h6-4">单价</li>
						<li class="h6-5">数量</li>
						<li class="h6-6">金额</li>
						<li class="h6-2"><button>结算</button></li>
					</ul>
				</div>

				<div class="h7">
					<ul>
					<c:if test="${empty sessionScope.cart.items}">
    								您的购物为空！
					</c:if>
    								
					<c:if test="${!empty sessionScope.cart.items}">
					<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
						<li class="h7-1"><input type="checkbox" /></li>
						<li class="h7-3">
							<div>
								<ul>
										<li class="h8-1">
										<c:if test="${!empty p.firstProductImage}">
												<img width="50px" height="50px"
													src="${pageContext.request.contextPath}/img/images/${p.firstProductImage.id}.jpg">
										</c:if> 
										<!-- <img width="50px" height="50px"
										src="../img/images/圣诞工艺品小鹿.jpg" /> --></li>
										<li class="h8-2"><a href="">${me.value.product.name}</a></li>
			
									
								</ul>
							</div>
						</li>
						
						<li class="h7-4">${me.value.product.promotePrice}</li>
						<li class="h7-6">
						<input type="text" size="3" id="number" name="number"
					value="${me.value.number}"
					onchange="changeNumber(this,'${me.value.number}','${me.key}')" />
					</li>
						
					</ul>
					</c:forEach>
				</c:if>
					
				</div>
			</div>

		</div>
		
		<div class="x3">
			<div class="l4">
				<ul>
					<li class="h6-1"><input type="checkbox" />全选</li>
					<li class="h9-4"><a href="#">删除</a></li>
				</ul>
			</div>
			<div class="r4">
				<ul>
					<li class="h9-5"><span>已选商品</span> <em><a href="#">1</a></em>
						<span>件</span></li>
					<li class="h9-6"><span>合计(不含运费)：</span> <em>¥</em> <em><a
							href="#">价格</a></em></li>
					<li class="h9-7">
						<button style="width: 80px; height: 30px; font-size: 15px;"><a href=
				"${pageContext.request.contextPath}/ClientServlet?op=genOrder&cartId=${sessionScope.cart.id}">
				结算</a></button>
					</li>
				</ul>
			</div>
		</div>
	</div>
	

<%-- 
<c:if test="${empty cart}">
    	您还没有购买任何商品
    </c:if>
<c:if test="${!empty cart}">
	<table border="1" width=800">
		<tr>
			<th>商品名</th>
			<th>二级标题</th>
			<th>售价</th>
			<th>数量</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${cart}" var="me" varStatus="vs">
			<tr class="${vs.index%2==0?'even':'odd'}">
				<td>${me.name}</td>
				<td>${me.subTitle}</td>
				<td>${me.promotePrice}</td>
				<td><input type="text" size="5" id="number" name="number"
					value="${me.value.number}"
					onchange="changeNumber(this,'${me.number}','${me.key}')" /></td>
				<td>${me.value.price}</td>
				<td><a href="javascript:delOneItem('${me.key}')">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td align="right" colspan="6">
				总数量：${cart.number}&nbsp;&nbsp;
				总金额：${cart.price}&nbsp;&nbsp; <a
				href="${pageContext.request.contextPath}/ClientServlet?op=genOrder&cartId="
				+${cart.id}>去结算</a>
			</td>
		</tr>
	</table>
</c:if> --%>

<script type="text/javascript">
    	function delOneItem(productId){
    		var sure = window.confirm("确定要删除吗？");
    		if(sure){
    			location.href="${pageContext.request.contextPath}/ClientServlet?op=delOneItem&productId="+productId;
    		}
    	}
    	function changeNumber(inputObj,oldNumber,productId){
    		var value = inputObj.value;
    		//验证值必须是自然整数
    		if(!/^[1-9][0-9]*$/.test(value)){
//     			改为1
				//inputObj.value=1;
				alert("请输入正确的数量");
				this.focus();
				return;
    		}
    		var sure = window.confirm("确定要修改数量为"+value+"吗？");
    		if(sure){
    			location.href="${pageContext.request.contextPath}/ClientServlet?op=changeNum&productId="+productId+"&num="+value;
    		}else{
    			//改回原来的数量
    			inputObj.value = oldNumber;
    		}
    	}
    </script>
</body>
</html>
