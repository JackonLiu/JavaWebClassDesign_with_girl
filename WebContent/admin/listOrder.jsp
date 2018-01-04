<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

    <c:if test="${empty orders}">
    	没有任何订单
    </c:if>
    <c:if test="${!empty orders}">
    <div class="listDataTableDiv">
    	<table class="table table-striped table-bordered table-hover table-condensed" >
    		<tr class="success">
    			<th>订单流水号</th>
    			<th>订单金额</th>
    			<th>数量</th>
    			<th>状态</th>
    			<th>编辑</th>
                <th>删除</th>
    		</tr>
    		<c:forEach items="${orders}" var="o" varStatus="vs">
    			<tr class="${vs.index%2==0?'even':'odd'}">
	    			<td>${o.id}</td>
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
	    			<td><a href="admin_order_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_order_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>
                
	    		</tr>
    		</c:forEach>
    	</table>
  		</div>
    </c:if>
  </body>
</html>
<%@include file="../include/admin/adminFooter.jsp"%>