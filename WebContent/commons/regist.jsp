<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/register.css" />
<script
	src="${pageContext.request.contextPath}/js/jquery/2.0.0/jquery.min.js"></script>
<title>用户注册</title>
<style type="text/css">
.s{
	width: 100%;
	height: 100px;
	background-color: burlywood;
	border-top-left-radius: 20px;
	border-top-right-radius: 20px;
	border-bottom-left-radius: 20px;
	border-bottom-right-radius: 20px;
	
}
.logo2{
	float: left;
	font-size: 20px;
	color: red;
	margin-left: 100px;
	margin-top: 5px;
	width: 50%;
}
.r1{
	float: right;
	margin-top: 35px;
	margin-right: 200px;
	font-size: 20px;
	color: gray;
}
.r1 a{
	font-size: 20px;
	color: gray;
	text-decoration: none;
}
.b1{
	color: black;
	background-color: wheat;
}
.x{
	border-top-right-radius: 20px;
	border-top-left-radius: 20px;
	border-bottom-left-radius: 20px;
	border-bottom-right-radius: 20px;
	background-color: burlywood;
	margin-top: 2px;
	width: 100%;
	height: 500px;
}
.l2{
	float: left;
	margin-left: 300px;
	color: #000000;
	width: 50%;
	height: 400px;
}
.t1{
	display: block;
    position: relative;
    float: left;
    height: 30px;
    width: 200px;
}
.h1{
	margin-top: 50px;
}
.h2{
	padding-top: 5px;
}
.r2{
	float: right;
}
.b2{
	font-size: 15px;
	width: 100px;
	color: black;
}


 *{  
                margin: 0px;  
                padding: 0px;  
            }  
            /*布局开始*/  
            #login_dialog {  
                position: fixed;  
                left: 40%;  
                top: 40%;  
                background-color: #303a40;  
                width: 500px;  
                margin-left: -200px;  
                margin-top: -150px;  
                font-family: "黑体";  
                -moz-user-select: none;  
                -webkit-user-select: none;  
                user-select:none;  
            }  
            .register_dialog_title {  
                height: 35px;  
                line-height: 35px;  
                margin: 0 5px;  
            }  
  
            .register_dialog_info {  
                float: left;  
                margin-left:10px;  
                color: #fff;  
                margin-top: 5px;  
                font-size: 20px;  
            }  
            #register_dialog {  
                position: fixed;  
                left: 40%;  
                top: 40%;  
                background-color: #303a40;  
                width: 500px;  
            /*  height: 600px; */  
                margin-left: -200px;  
                margin-top: -200px;  
                font-family: "黑体";  
                -moz-user-select:none; /*火狐*/  
                -webkit-user-select:none; /*webkit浏览器*/  
                -ms-user-select:none; /*IE10*/  
                -khtml-user-select:none; /*早期浏览器*/  
                user-select:none;  
            }  
  
            .register_dialog_info {  
                float: left;  
                margin-left:10px;  
                color: #fff;  
                margin-top: 5px;  
                font-size: 20px;  
            }  
            .dialog_close {  
                cursor: pointer;  
                width: 40px;  
                height:40px;  
                border-radius:25px;  
                float: right;  
                line-height:40px;  
                font-size: 20px;  
                color: #d8dadb;  
                font-family: "微软雅黑";  
                text-align: center;  
                cursor:center;  
            }  
            form{padding: 20px 0px;}  
            ul li {list-style: none;}  
            .sub {  
                text-align: center;  
            }  
            .sub input {  
                display: inline-block;  
                width: 220px;  
                background-color: rgb(255, 109, 11);  
                color: rgb(255, 255, 255);  
                font-size: 20px;  
                text-align: center;  
                height: 40px;  
                line-height: 40px;  
                font-family: 黑体;  
                outline: none;  
                border: none;  
                margin: auto;  
            }  
            .dialog_close:hover {  
                background-color: #566  
            }  
            input[type = "submit"]:hover{cursor: pointer;}  
            /*布局结束*/  
            .reg-box { padding-left: 30px; }  
  
            .reg-box li { line-height: 44px; width: 500px; overflow: hidden; }  
  
            .reg-box li label { width: 68px; height: 50px; float: left; line-height: 50px; text-align: right; padding-right: 20px; }  
  
            .reg-box li input,.reg-box li select{ padding: 6px 0;margin-top:8px; font-size: 16px; width: 296px;text-align: left; height: 28px; line-height: 28px; border: 1px solid #dddddd; text-indent: 0.5em; float: left; }  
  
            .reg-box li select option{font-size:16px;}  
  
            .registered .btn a { background: #ff7200; margin-left: 110px; }  
              
            input { background-color: #fff; outline: none; }  
  
            .reg-box li { width: auto; }  
  
            .reg-box li input.errorC, .errorC{ border: 1px solid red; }  
  
            .reg-box li input.checkedN , .checkedN{ border: 1px solid #1ece6d; }  
              </style>
<script type="text/javascript">	
	//文本框默认提示文字
	function textFocus(el) {
	    if (el.defaultValue == el.value) { el.value = ''; el.style.color = '#333'; }
	}
	function textBlur(el) {
	    if (el.value == '') { el.value = el.defaultValue; el.style.color = '#999'; }
	}

	$(function(){ 
		//注册页面的提示文字
	   (function register(){
		   //手机号栏失去焦点
			$(".reg-box .phone").blur(function(){
				reg=/^1[3|4|5|7|8][0-9]\d{4,8}$/i;//验证手机正则(输入前7位至11位)

				if( $(this).val()==""|| $(this).val()=="请输入您的手机号")
				{ 
					$(this).addClass("errorC");
					$(this).next().html("请输入您的手机号");
					$(this).next().css("display","block");
				}
				else if($(this).val().length<11)
				{   
					$(this).addClass("errorC");
					$(this).next().html("手机号长度有误！");
					$(this).next().css("display","block");
				}
				else if(!reg.test($(".reg-box .phone").val()))
				{   
					$(this).addClass("errorC");
					$(this).next().html("手机号不存在!");
					$(this).next().css("display","block");
				}
				else
				{
					$(this).addClass("checkedN");
					$(this).removeClass("errorC");
					$(this).next().empty();
				}
			});


			//密码栏失去焦点
			$(".reg-box .password").blur(function(){
				reg=/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
				if(!reg.test($(".password").val()))
				{
					$(this).addClass("errorC");
					$(this).next().html("格式有误，请输入6~12位的数字、字母或特殊字符！");
					$(this).next().css("display","block");
				}
				else 
				{
					$(this).removeClass("errorC");
					$(".reg-box .error3").empty();
					$(this).addClass("checkedN");
				}
			});
			/*确认密码失去焦点*/
			$(".reg-box .email").blur(function(){
				var pwd1=$('.reg-box input.password').val();
				var pwd2=$(this).val();
				if(($(this).val() == '请再次输入密码' || $(this).val() == "") && (pwd1 == "请输入密码" || pwd1 == "") ){					
						return;
				}else if(pwd1!=pwd2)
				{
					$(this).addClass("errorC");
					$(this).removeClass("checkedN");
					$(this).next().html("两次密码输入不一致！");

					$(this).next().css("display","block");
				}
				else 
				{
					$(this).removeClass("errorC");
					$(this).next().empty();
					$(this).addClass("checkedN");
				}
			});
	   })();
		
		//账户输入框失去焦点
		(function login_validate(){
			$(".reg-box .account").blur(function(){
				reg=/^1[3|4|5|8][0-9]\d{4,8}$/i;//验证账户正则(输入前7位至11位)
//^-开始
				if( $(this).val()==""|| $(this).val()=="请输入您的账号")
				{ 
					$(this).addClass("errorC");
					$(this).next().html("账号不能为空！");
					$(this).next().css("display","block");
				}
				else if($(".reg-box .account").val().length<11)
				{   
					$(this).addClass("errorC");
					$(this).next().html("账号长度有误！");
					$(this).next().css("display","block");
				}
				else
				{
					$(this).addClass("checkedN");
					$(this).removeClass("errorC");
					$(this).next().empty();
				}
			});
			

		})();
	});	
	
   form1.submit();

/* 	清除提示信息正则表达式

位置：
       ^      开头
       $      结尾
次数：
       *      0或多个
       +      1或多个
       ?      0或1个
       {n}     就是n个
       {n,}   至少n个
       {n,m}  最少n个，最多m个
通配符：
       \d     任意数字
       \D     任意非数字
       \s     任意空白
       \S     任意非空白
       .      任意字符（除'\n'外）
组合：
       [a-z]
       [0-9]
       等组：
       (正则)     匹配括号中正则表达式对应的结果，并暂存这个结果。
       (?:正则)   匹配括号中正则表达式对应的结果，但不暂存这个结果。
       \数字      使用第n个组匹配的结果
使用正则的工具（RegExp类与相关方法）

标志：
    g （全文查找出现的所有 pattern）
    i （忽略大小写）
    m （多行查找）*/
	function emptyRegister(){
		$(".reg-box .phone,.reg-box .phonekey,.reg-box .password,.reg-box ").removeClass("errorC");;
		$(".reg-box .error1,.reg-box .error2,.reg-box .error3,.reg-box .error4").empty();
	}
</script>
</head>

<body>
	<div>
		<div class="s">
			<!--上部分-->
			<div class="logo2">
				<table width="350px" align="center">
					<tr>
						<td><img style="" 100px" height="80px"
							src="../img/images/orange.jpg" /></td>
						<td>注册橙子账号</td>
					</tr>
				</table>
			</div>
			<div class="r1">
				<table width="300px">
					<tr>
						<td><a href="../index.jsp">首页 </a></td>
						<td style="font-size: 15px;">我已注册，现在&nbsp;&nbsp;<a
							href="../commons/login.jsp"><button class="b1">登录</button></a></td>

					</tr>
				</table>
			</div>

		</div>
		<div class="x">
			<!--下部分-->
			<div class="l2">
				<form
					action="${pageContext.request.contextPath}/ClientServlet?op=customerRegist"
					method="post" id="form1">
					<ul class="reg-box">
						<li><label for="">用户名:  </label>
						<input type="text" name="username" placeholder="请设置用户名"
							class="account" onBlur="textBlur(this)" onFocus="textFocus(this)"/>
							<span class="error error2"></span></li>
					
						<li><label for="">手 机:     </label><input  type="text"
							name="phone" value="请填写11位的手机号" class="phone" maxlength="11"
							style="color: #999;" onBlur="textBlur(this)"
							onFocus="textFocus(this)" />
							<span class="error error1"></span></li>

						<li><label for="">密 码  :      </label><input type="password"
							name="password" class="password"  value="请输入密码" style="color: #999;"
							onBlur="textBlur(this)" onFocus="textFocus(this)" /><span
							class="error error3"></span></li>
						<li><label for="">确认密码:</label><input type="password"
							name="password" class="email" value="请再次输入密码" style="color: #999;"
							onBlur="textBlur(this)" onFocus="textFocus(this)" /><span
							class="error error4"></span></li>
					</ul>
					   <div class="sub">  
                    <input type="submit" value="立即注册" />  
                      
                		</div>  
				</form>
			</div>
		</div>
	</div>


</body>
</html>
