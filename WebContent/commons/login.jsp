<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/login.css" />
<script
	src="${pageContext.request.contextPath}/js/jquery/2.0.0/jquery.min.js"></script>
<title>用户登录</title>
<script> 

$(function() {
	//密码栏失去焦点
	$("#password").blur(function(){
		reg=/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
		if(!reg.test($("#password").val()))
		{
			$(this).addClass("errorC");
			$(this).next().html("格式有误，请输入6~12位的数字、字母或特殊字符！");
			$(this).next().css("display","block");
		}
		else 
		{
			$(this).removeClass("errorC");
			$(".error3").empty();
			$(this).addClass("checkedN");
		}
	});
	
	$(".login").click(function() {  
	// 处理表单验证和交给后台处理的逻辑  
	    var oError = document.getElementById("error_box");  
	    var userName = $("#username").val();  
	    var password = $("#password").val();  
	    var isNotError = true;  
	    if(userName==""){  
	        oError.innerHTML = "用户名为空 ";  
	        isNotError = false;  
	        $("#username").focus();  
	        return;  
	    }  
	    if(password==""){  
	        oError.innerHTML = "密码为空 ";  
	        isNotError = false;  
	        $("#password").focus();  
	        return;  
	    }  
	    $.ajax({  
	        type: "POST",  
	        url: "http://localhost:8080/orange_mall/ClientServlet?op=login",  
	        dataType: "json",  
	        data: {"username":userName,"password":password}, 
	         statusCode: {404: function() {  
	            alert('page not found');
	            window.location.href = "index.jsp"}  
	         }, 
		         success:function(data){
		             if(data == false){
		                 alert("您输入的用户名或密码有错！");
		                 loginform.username.focus();
		                 return false;
		             }else{
		            	 window.location.href = "http://localhost:8080/orange_mall/index.jsp";
		            	 //跳转到主页
		             }
		         },
	    }); 
	});  
	});  
	

</script>  
</head>
<body>
	<div class="menu">
		<div class="s">
			<!--上部分-->
			<div class="logo3">
				<table  >
					<tr>
						<td><img width="100px" height="80px"
							src="${pageContext.request.contextPath}/img/images/orange.jpg" /></td>
						<td>登录橙子账号</td>
					</tr>
				</table>
			</div>
			<div class="r1">
				<ul>
					<li><a href="../index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="regist.jsp">注册</a></li>
				</ul>
			</div>
		</div>
		
		<div class="x">
		
			<form id="loginform">  
			    <div class="box">  
			        <div id="error_box"></div>  
			        <div class="input_box">  
			            <input type="text" placeholder="请输入账户名" id="username" name="username"/>  
			        </div>  
			        <div class="input_box">  
			            <input type="password" placeholder="请输入密码" id="password" name="password"/>  
			        <span
							class="error3"></span>
			        </div>  
			        <div class="input_box">  
			            <!-- type="button"这里的要这样写不让页面会默认为type="submit"，
			            ajax 提交时页面是不用刷新页面的   而表单提交需要刷新，这里我们是不用刷新-->  
			          <span style="color:#FF6666;">
			           <button id="login" type="button" class="login" >登录</button></span>  
			        </div>  
			    </div>  
			</form>  
			</div>
	</div>
</body>
</html>
