<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>橙子商城</title>
<meta http-equiv="description" content="橙子商城">
<title></title>
</head>
<body>

	<div class="h1" style="margin-top: 40px;">
		<!--第二行-->
		<jsp:forward page="/ClientServlet">
			<jsp:param value="listProducts" name="op" />
		</jsp:forward>
		
	</div>

</body>
</html>
