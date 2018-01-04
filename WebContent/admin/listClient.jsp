<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script >
	$(function() {
		$("#addForm").submit(function() {
			if (checkEmpty("name", "用户名"))
				return true;
			return false;
		});
	});
</script>

<title>用户管理</title>


<div class="workingArea">

	<ol class="breadcrumb">
	  <li><a href="admin_Client_list?op=showUsers">${c.name}</a></li>
	  <li class="active">用户管理</li>
	</ol>


	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>用户名</th>
					<th>密码：</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${beans}"  var="u">

					<tr>
						<td>${u.id}</td>
						<td>${u.name}</td>
						<td>${u.password}</td>
						<td><a href="admin_Client_edit?id=${u.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a deleteLink="true"
							href="admin_Client_delete?id=${u.id}"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp"%>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增用户</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="admin_Client_add?op=addUser">
				<table class="addTable">
					<tr>
						<td>用户名</td>
						<td><input id="name" type="text" name="name"
								class="form-control"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input id="password" type="password" name="password"
								class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="uid" value="${u.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@include file="../include/admin/adminFooter.jsp"%>